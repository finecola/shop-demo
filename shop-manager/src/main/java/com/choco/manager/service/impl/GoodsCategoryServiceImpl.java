package com.choco.manager.service.impl;

import com.choco.common.utils.JsonUtil;
import com.choco.manager.entity.GoodsCategory;
import com.choco.manager.entity.GoodsCategoryExample;
import com.choco.manager.mapper.GoodsCategoryMapper;
import com.choco.manager.mapper.GoodsMapper;
import com.choco.manager.service.GoodsCategoryService;
import com.choco.manager.vo.GoodsCategoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by choco on 2020/12/28 22:38
 */
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {
    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Value("${goods.category.list.key}")
    public String goodsCategoryListKey;

    @Override
    public List<GoodsCategory> selectCategoryTopList() {
        //创建查询对象
        GoodsCategoryExample example = new GoodsCategoryExample();
        //设置查询条件
        example.createCriteria().andParentIdEqualTo((short) 0);

        return goodsCategoryMapper.selectByExample(example);
    }

    @Override
    public List<GoodsCategory> selectCategorySecond(short parentId) {
        GoodsCategoryExample example = new GoodsCategoryExample();
        example.createCriteria().andParentIdEqualTo(parentId);

        return goodsCategoryMapper.selectByExample(example);
    }

    @Override
    public int categorySave(GoodsCategory goodsCategory) {
        //受影响的行数
        return goodsCategoryMapper.insertSelective(goodsCategory);
    }

    @Override
    public List<GoodsCategoryVo> selectCategoryListVo() {
        /*GoodsCategoryExample example = new GoodsCategoryExample();
        example.createCriteria().andParentIdEqualTo((short) 0).andLevelEqualTo(1);

        //查询GoodsCategory. 创建一级分类的List<GoodsCategoryVo>
        List<GoodsCategory> gcList1 = goodsCategoryMapper.selectByExample(example);
        List<GoodsCategoryVo> gcvList1 = new ArrayList<>();
        //GoodsCategory转换为GoodsCategoryGoodsCategoryVo
        for (GoodsCategory gc1 : gcList1) {
            GoodsCategoryVo gcv1 = new GoodsCategoryVo();
            BeanUtils.copyProperties(gc1, gcv1);
            example.clear();

            example.createCriteria().andParentIdEqualTo(gc1.getId()).andLevelEqualTo(2);

            // 创建二级分类的List<GoodsCategoryVo>
            List<GoodsCategory> gcList2 = goodsCategoryMapper.selectByExample(example);
            List<GoodsCategoryVo> gcvList2 = new ArrayList<>();

            for (GoodsCategory gc2 : gcList2) {
                GoodsCategoryVo gcv2 = new GoodsCategoryVo();
                BeanUtils.copyProperties(gc2, gcv2);

                //查询三级分类,放入二级的children里面
                example.clear();
                example.createCriteria().andParentIdEqualTo(gc2.getId()).andLevelEqualTo(3);
                List<GoodsCategory> gcList3 = goodsCategoryMapper.selectByExample(example);

                // 新建一个gcvList3
                List<GoodsCategoryVo> gcvList3 = new ArrayList<>();
                for (GoodsCategory gc3 : gcList3) {
                    GoodsCategoryVo gcv3 = new GoodsCategoryVo();
                    BeanUtils.copyProperties(gc3, gcv3);
                    gcvList3.add(gcv3);
                }
                // 把三级分类的gcv设置为二级分类的children.
                gcv2.setChildren(gcvList3);

                // 把二级分类的gc转换为gcv, 放入一个list
                gcvList2.add(gcv2);
            }

            // 设置
            gcv1.setChildren(gcvList2);
            // 一级分类GoodsCategoryVo也是个集合, 需要放入List<GoodsCategoryVo> gcvList1
            gcvList1.add(gcv1);
        }
        // 返回一级GoodsCategoryVo的集合*/

        //判断缓存
        ValueOperations<String, String> valueOperation = redisTemplate.opsForValue();
        String gcvListJson = valueOperation.get(goodsCategoryListKey);
        if (!StringUtils.isEmpty(gcvListJson)) {
            return JsonUtil.jsonToList(gcvListJson, GoodsCategoryVo.class);
        }

        GoodsCategoryExample example = new GoodsCategoryExample();
        //查询所有商品
        List<GoodsCategory> list = goodsCategoryMapper.selectByExample(example);

        //把gcv添加至gcvList
        List<GoodsCategoryVo> gcvList = list.stream().map(e -> {
            GoodsCategoryVo gcv = new GoodsCategoryVo();
            BeanUtils.copyProperties(e, gcv);
            return gcv;
        }).collect(Collectors.toList());

        //按照gcv的parentId进行存储, value为对于parentId的gcvList集合
        Map<Short, List<GoodsCategoryVo>> map = gcvList.stream().collect(Collectors.groupingBy(GoodsCategoryVo::getParentId));

        //循环给gcv赋值
        gcvList.forEach(e -> {
            //把自己的id作为上面map集合里面的parentId查询,即为它的child.
            e.setChildren(map.get(e.getId()));
        });

        //拦截器,返回level为1的 gcvList1
        List<GoodsCategoryVo> gcvList1 = gcvList.stream().filter(e -> 1 == e.getLevel()).collect(Collectors.toList());

        //放入redis缓存
        valueOperation.set(goodsCategoryListKey, JsonUtil.object2JsonStr(gcvList1));

        return gcvList1;
    }

    @Override
    public List<GoodsCategory> selectAllCategory() {
        return goodsCategoryMapper.selectByExample(new GoodsCategoryExample());
    }
}
