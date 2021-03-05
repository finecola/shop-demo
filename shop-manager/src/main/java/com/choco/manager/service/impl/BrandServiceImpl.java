package com.choco.manager.service.impl;

import com.choco.manager.entity.Brand;
import com.choco.manager.entity.BrandExample;
import com.choco.manager.mapper.BrandMapper;
import com.choco.manager.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by choco on 2020/12/31 17:13
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;
    @Override
    public List<Brand> selectAllBrand() {
        return brandMapper.selectByExample(new BrandExample());
    }
}
