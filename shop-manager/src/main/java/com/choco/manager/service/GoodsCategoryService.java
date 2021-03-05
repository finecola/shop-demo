package com.choco.manager.service;

import com.choco.manager.entity.GoodsCategory;
import com.choco.manager.vo.GoodsCategoryVo;

import java.util.List;

/**
 * Created by choco on 2020/12/28 22:36
 */
public interface GoodsCategoryService {
    /**
     * 商品分类-新增分类-顶级分类
     *
     * @return
     */
    List<GoodsCategory> selectCategoryTopList();

    /**
     * 查询二级分类
     *
     * @param parentId
     * @return
     */
    List<GoodsCategory> selectCategorySecond(short parentId);

    /**
     * 商品分类-新增分类-保存分类
     */
    int categorySave(GoodsCategory goodsCategory);

    /**
     * 商品分类-列表
     */
    List<GoodsCategoryVo> selectCategoryListVo();

    /**
     * 查询所有的商品分类
     * @return
     */
    List<GoodsCategory> selectAllCategory();
}
