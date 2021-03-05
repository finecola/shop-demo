package com.choco.manager.service;

import com.choco.common.result.BaseResult;
import com.choco.manager.entity.GoodsImage;

/**
 * Created by choco on 2021/1/1 17:55
 */
public interface GoodsImageService {
    /**
     * 上传图片. 并返回图片的url
     * @param goodsImage
     * @return
     */
    BaseResult saveGoodsImage(GoodsImage goodsImage);
}
