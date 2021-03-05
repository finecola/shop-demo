package com.choco.portal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.choco.common.result.ShopPageInfo;
import com.choco.rpc.service.SearchService;
import com.choco.rpc.vo.GoodsVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by choco on 2021/1/5 14:36
 */
@Controller
@RequestMapping("search")
public class SearchController {
    @Reference(interfaceClass = SearchService.class)
    private SearchService searchService;

    @RequestMapping("index")
    public String searchByKeyword(String keyword, Model model) {
        model.addAttribute("keyword", keyword);
        return "search/doSearch";
    }

    @ResponseBody
    @RequestMapping("goods")
    public ShopPageInfo<GoodsVo> searchGoods(String keyword, int pageNum, int pageSize) {
        return searchService.searchGoodsVo(keyword, pageNum, pageSize);
    }
}
