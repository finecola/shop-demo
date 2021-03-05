package com.choco.manager.service.impl;

import com.choco.common.result.BaseResult;
import com.choco.common.utils.JsonUtil;
import com.choco.manager.entity.Goods;
import com.choco.manager.entity.GoodsExample;
import com.choco.manager.mapper.GoodsMapper;
import com.choco.manager.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.util.HtmlUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by choco on 2020/12/31 22:12
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public BaseResult saveGoods(Goods goods) {
        if (goods != null) {
            return BaseResult.error();
        }
        //清除缓存
        redisTemplate.delete(redisTemplate.keys("goods*"));

        if (StringUtils.isEmpty(goods.getGoodsContent())) {
            //保存前, 判断goodsContent是否为空, 并进行html转义
            goods.setGoodsContent(HtmlUtils.htmlEscape(goods.getGoodsContent(), "utf-8"));
        }
        //返回的是goodsId,设置了selectKey属性
        int goodsId = goodsMapper.insertSelective(goods);
        BaseResult baseResult = BaseResult.error();
        BaseResult.error();
        if (goodsId > 0) {
            baseResult.setMessage(String.valueOf(goodsId));
            baseResult = BaseResult.success();
        }
        return baseResult;
    }

    @Override
    public BaseResult pageSelect(Goods goods, Integer pageNum, Integer pageSize) {
        // 创建redis key
        String[] goodsListKey = new String[]{
                "goods:pageNum_" + pageNum + ":pageSize_" + pageSize + ":",
                "catId",
                "brandId",
                "keyWord",
        };

        //构建分页对象
        PageHelper.startPage(pageNum, pageSize);
        //create example
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        //设置具体的查询条件
        if (goods.getCatId() != null && goods.getCatId() != 0) {
            criteria.andCatIdEqualTo(goods.getCatId());
            goodsListKey[1] = "catId_" + goods.getCatId() + ":";
        }

        if (goods.getBrandId() != null && goods.getBrandId() != 0) {
            criteria.andBrandIdEqualTo(goods.getBrandId());
            goodsListKey[2] = "brandId_" + goods.getBrandId() + ":";
        }
        //模糊查询, 关键词搜索
        if (goods.getGoodsName().length() != 0) {
            criteria.andGoodsNameLike("%" + goods.getGoodsName() + "%");
            goodsListKey[3] = "goodsName_" + goods.getGoodsName();
        }

        //把数组转换为字符串
        String goodsKey = Arrays.stream(goodsListKey).collect(Collectors.joining());
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String pageInfoJson = valueOperations.get(goodsKey);

        if (!StringUtils.isEmpty(pageInfoJson)) {
            return BaseResult.success(JsonUtil.jsonStr2Object(pageInfoJson, PageInfo.class));
        }

        List<Goods> goodsList = goodsMapper.selectByExample(example);
        //如果结果不为空,放入分页对象
        if (!CollectionUtils.isEmpty(goodsList)) {
            PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
            valueOperations.set(goodsKey, JsonUtil.object2JsonStr(pageInfo));
            return BaseResult.success(pageInfo);
        } else {
            //没查询到数据, 放入空数组
            valueOperations.set(goodsKey, JsonUtil.object2JsonStr(new PageInfo<Goods>(new ArrayList<Goods>())), 60L, TimeUnit.SECONDS);
        }
        return BaseResult.error();
    }
}
