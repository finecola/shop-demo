package com.choco.manager.service;

import com.choco.manager.entity.Brand;

import java.util.List;

/**
 * Created by choco on 2020/12/31 17:11
 */
public interface BrandService {
    /**
     * 查询所有的品牌分类
     * @return
     */
    List<Brand> selectAllBrand();
}
