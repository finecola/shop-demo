package com.choco.portal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.choco.rpc.service.GoodsCategoryService;
import com.choco.rpc.vo.GoodsCategoryVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by choco on 2021/1/3 18:01
 */
@Controller
@RequestMapping("goodsCategory")
public class GoodsController {
    @Reference(interfaceClass = GoodsCategoryService.class)
    private GoodsCategoryService goodsCategoryService;

    @ResponseBody
    @GetMapping("list")
    public List<GoodsCategoryVo> selectCategoryListForView(){
        return goodsCategoryService.selectCategoryListVo();
    }
}
