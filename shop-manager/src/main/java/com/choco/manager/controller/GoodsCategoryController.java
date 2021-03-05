package com.choco.manager.controller;

import com.choco.common.result.BaseResult;
import com.choco.manager.entity.GoodsCategory;
import com.choco.manager.service.impl.GoodsCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by choco on 2020/12/28 20:27
 */
@Controller
@RequestMapping("goods/category")
public class GoodsCategoryController {
    @Autowired
    private GoodsCategoryServiceImpl goodsCategoryService;

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("gcvList", goodsCategoryService.selectCategoryListVo());
        return "goods/category/category-list";
    }

    /**
     * 跳转到新增分类页面,并预先查询好顶级分类
     *
     * @param model
     * @return
     */
    @RequestMapping("add")
    public String add(Model model) {
        List<GoodsCategory> categoryTopList = goodsCategoryService.selectCategoryTopList();
        model.addAttribute("categoryTopList", categoryTopList);
        return "goods/category/category-add";
    }

    /**
     * 根据一级分类,查询二级分类
     *
     * @param parentId
     * @return
     */
    @RequestMapping("{parentId}")
    @ResponseBody
    public List<GoodsCategory> secondList(@PathVariable("parentId") short parentId) {
        return goodsCategoryService.selectCategorySecond(parentId);
    }

    /**
     * 商品分类-新增分类-保存分类
     *
     * @param goodsCategory
     * @return
     */
    @RequestMapping("save")
    @ResponseBody
    public BaseResult goodsCategorySave(GoodsCategory goodsCategory) {
        int rows = goodsCategoryService.categorySave(goodsCategory);
        return rows > 0 ? BaseResult.success() : BaseResult.error();
    }
}
