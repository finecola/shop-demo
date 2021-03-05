package com.choco.rpc.service;

import com.choco.rpc.vo.GoodsCategoryVo;

import java.util.List;

/**
 * Created by choco on 2020/12/28 22:36
 */
public interface GoodsCategoryService {
    /**
     * 商品分类-列表
     */
    List<GoodsCategoryVo> selectCategoryListVo();
}
