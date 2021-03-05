package com.choco.rpc.service;

import com.choco.common.result.ShopPageInfo;
import com.choco.rpc.vo.GoodsVo;

/**
 * Created by choco on 2021/1/5 10:40
 */
public interface SearchService {
    ShopPageInfo<GoodsVo> searchGoodsVo(String keyword, int pageNum, int pageSize);
}
