package com.choco.manager.service.impl;

import com.choco.common.result.BaseResult;
import com.choco.manager.entity.GoodsImage;
import com.choco.manager.mapper.GoodsImageMapper;
import com.choco.manager.service.GoodsImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by choco on 2021/1/1 17:56
 */
@Service
public class GoodsImageServiceImpl implements GoodsImageService {
    @Autowired
    private GoodsImageMapper goodsImageMapper;

    @Override
    public BaseResult saveGoodsImage(GoodsImage goodsImage) {
        return goodsImageMapper.insertSelective(goodsImage)>0?BaseResult.success():BaseResult.error();
    }
}
