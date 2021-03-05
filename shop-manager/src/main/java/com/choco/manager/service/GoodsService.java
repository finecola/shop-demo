package com.choco.manager.service;

import com.choco.common.result.BaseResult;
import com.choco.manager.entity.Goods;

/**
 * Created by choco on 2020/12/31 22:11
 */
public interface GoodsService {
    /**
     * 商品列表-新增商品-保存
     */
    BaseResult saveGoods(Goods goods);

    /**
     * 分页查询和模糊查询
     */
    BaseResult pageSelect(Goods goods, Integer pageNum, Integer pageSize);
}
