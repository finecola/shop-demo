package com.choco.portal;

import com.alibaba.dubbo.config.annotation.Reference;
import com.choco.common.entity.Admin;
import com.choco.common.result.BaseResult;
import com.choco.common.result.ShopPageInfo;
import com.choco.common.utils.JsonUtil;
import com.choco.rpc.service.CartService;
import com.choco.rpc.service.GoodsCategoryService;
import com.choco.rpc.service.SearchService;
import com.choco.rpc.vo.CartVo;
import com.choco.rpc.vo.GoodsVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
class ShopPortalApplicationTests {
    @Reference(interfaceClass = GoodsCategoryService.class)
    private GoodsCategoryService goodsCategoryService;
    @Reference(interfaceClass = SearchService.class)
    private SearchService searchService;
    @Reference(interfaceClass = CartService.class)
    private CartService cartService;

    @Test
    void contextLoads() {
        ShopPageInfo<GoodsVo> shopPageInfo = searchService.searchGoodsVo("中国电信", 1, 10);
        System.out.println(JsonUtil.object2JsonStr(shopPageInfo));
    }

    @Test
    void testAddCart(){
        Admin admin = new Admin();
        admin.setAdminId((short) 2);

        CartVo cartVo = new CartVo();
        cartVo.setGoodsId(123);
        cartVo.setGoodsName("anne");
        cartVo.setGoodsNum(10);
        cartVo.setAddTime(new Date());
        cartVo.setMarketPrice(new BigDecimal("100"));
        BaseResult baseResult = cartService.addCart(cartVo, admin);
        System.out.println(baseResult.getCode());
        System.out.println(baseResult.getMessage());
    }

    @Test
    void testGetCart(){
        Admin admin = new Admin();
        admin.setAdminId((short) 1);

        System.out.println(cartService.getCartNums(admin));
    }
}
