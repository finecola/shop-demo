package com.choco.manager.controller;

import com.choco.common.result.BaseResult;
import com.choco.common.result.FileResult;
import com.choco.manager.entity.Brand;
import com.choco.manager.entity.Goods;
import com.choco.manager.entity.GoodsCategory;
import com.choco.manager.entity.GoodsImage;
import com.choco.manager.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by choco on 2020/12/31 22:18
 */
@Controller
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsCategoryServiceImpl goodsCategoryService;

    @Autowired
    private GoodsServiceImpl goodsService;

    @Autowired
    private BrandServiceImpl brandService;

    @Autowired
    private GoodsImageServiceImpl goodsImageService;

    @Autowired
    private UploadServiceImpl uploadService;

    /**
     * 商品新增-保存
     */
    @PostMapping("save")
    @ResponseBody
    public BaseResult goodsSave(Goods goods, Model model) {
        return goodsService.saveGoods(goods);
    }

    @RequestMapping("list")
    public String goodsList(Model model) {
        //查询所有的商品分类
        List<GoodsCategory> gcList = goodsCategoryService.selectAllCategory();
        //查询所有的品牌分类
        List<Brand> brandList = brandService.selectAllBrand();

        model.addAttribute("gcList", gcList);
        model.addAttribute("brandList", brandList);
        return "goods/goods-list";
    }

    /**
     * 跳转到goods-add.ftl页面
     */
    @RequestMapping("add")
    public String goodsAdd(Model model) {
        /**
         * 商品列表-添加新商品-商品分类
         */
        List<GoodsCategory> gcList = goodsCategoryService.selectCategoryTopList();
        model.addAttribute("gcList", gcList);
        /**
         * 商品列表-添加新商品-品牌分类
         */
        List<Brand> brandList = brandService.selectAllBrand();
        model.addAttribute("brandList", brandList);
        return "goods/goods-add";
    }

    /**
     * 商品的图片上传 和 与商品绑定
     */
    @ResponseBody
    @PostMapping("image/save")
    public BaseResult saveImage(MultipartFile file, int goodsId) throws IOException {
        String filename = file.getOriginalFilename();
        //防止filename重复
        filename = DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDateTime.now()) + System.currentTimeMillis() + filename.substring(filename.lastIndexOf("."));
        FileResult fileResult = uploadService.upload(file.getInputStream(), filename);
        //判断图片上传是否成功
        if (fileResult != null) {
            //获取图片的url,是一个完整路径.
            String imageUrl = fileResult.getFileUrl();
            GoodsImage goodsImage = new GoodsImage();
            goodsImage.setImageUrl(imageUrl);
            goodsImage.setGoodsId(goodsId);
            BaseResult baseResult = goodsImageService.saveGoodsImage(goodsImage);
            if (baseResult != null) {
                return BaseResult.success();
            } else {
                return BaseResult.error();
            }
        }
        return BaseResult.error();
    }

    /**
     * 商品列表-分页查询
     * @param goods
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping("pageselect")
    public BaseResult pagaSelect(Goods goods, Integer pageNum, int pageSize){
        return goodsService.pageSelect(goods, pageNum, pageSize);
    }
}
