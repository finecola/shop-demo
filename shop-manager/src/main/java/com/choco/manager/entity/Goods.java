/*
*
* Goods.java
* Copyright(C) 2017-2020 fendo公司
* @date 2020-12-31
*/
package com.choco.manager.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Goods implements Serializable {
    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 分类id
     */
    private Integer catId;

    /**
     * 扩展分类id
     */
    private Integer extendCatId;

    /**
     * 商品编号
     */
    private String goodsSn;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 点击数
     */
    private Integer clickCount;

    /**
     * 品牌id
     */
    private Short brandId;

    /**
     * 库存数量
     */
    private Short storeCount;

    /**
     * 商品评论数
     */
    private Short commentCount;

    /**
     * 商品重量克为单位
     */
    private Integer weight;

    /**
     * 市场价
     */
    private BigDecimal marketPrice;

    /**
     * 本店价
     */
    private BigDecimal shopPrice;

    /**
     * 商品成本价
     */
    private BigDecimal costPrice;

    /**
     * 商品关键词
     */
    private String keywords;

    /**
     * 商品简单描述
     */
    private String goodsRemark;

    /**
     * 商品上传原始图
     */
    private String originalImg;

    /**
     * 是否为实物
     */
    private Byte isReal;

    /**
     * 是否上架
     */
    private Boolean isOnSale;

    /**
     * 是否包邮0否1是
     */
    private Boolean isFreeShipping;

    /**
     * 商品上架时间
     */
    private Integer onTime;

    /**
     * 商品排序
     */
    private Short sort;

    /**
     * 是否推荐
     */
    private Boolean isRecommend;

    /**
     * 是否新品
     */
    private Boolean isNew;

    /**
     * 是否热卖
     */
    private Boolean isHot;

    /**
     * 最后更新时间
     */
    private Integer lastUpdate;

    /**
     * 商品所属类型id，取值表goods_type的cat_id
     */
    private Short goodsType;

    /**
     * 商品规格类型，取值表goods_type的cat_id
     */
    private Short specType;

    /**
     * 购买商品赠送积分
     */
    private Integer giveIntegral;

    /**
     * 积分兑换：0不参与积分兑换，积分和现金的兑换比例见后台配置
     */
    private Integer exchangeIntegral;

    /**
     * 供货商ID
     */
    private Short suppliersId;

    /**
     * 商品销量
     */
    private Integer salesSum;

    /**
     * 0 普通订单,1 限时抢购, 2 团购 , 3 促销优惠
     */
    private Boolean promType;

    /**
     * 优惠活动id
     */
    private Integer promId;

    /**
     * 佣金用于分销分成
     */
    private BigDecimal commission;

    /**
     * SPU
     */
    private String spu;

    /**
     * SKU
     */
    private String sku;

    /**
     * 商品详细描述
     */
    private String goodsContent;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     * @return goods_id 商品id
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 商品id
     * @param goodsId 商品id
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 分类id
     * @return cat_id 分类id
     */
    public Integer getCatId() {
        return catId;
    }

    /**
     * 分类id
     * @param catId 分类id
     */
    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    /**
     * 扩展分类id
     * @return extend_cat_id 扩展分类id
     */
    public Integer getExtendCatId() {
        return extendCatId;
    }

    /**
     * 扩展分类id
     * @param extendCatId 扩展分类id
     */
    public void setExtendCatId(Integer extendCatId) {
        this.extendCatId = extendCatId;
    }

    /**
     * 商品编号
     * @return goods_sn 商品编号
     */
    public String getGoodsSn() {
        return goodsSn;
    }

    /**
     * 商品编号
     * @param goodsSn 商品编号
     */
    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn == null ? null : goodsSn.trim();
    }

    /**
     * 商品名称
     * @return goods_name 商品名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 商品名称
     * @param goodsName 商品名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * 点击数
     * @return click_count 点击数
     */
    public Integer getClickCount() {
        return clickCount;
    }

    /**
     * 点击数
     * @param clickCount 点击数
     */
    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    /**
     * 品牌id
     * @return brand_id 品牌id
     */
    public Short getBrandId() {
        return brandId;
    }

    /**
     * 品牌id
     * @param brandId 品牌id
     */
    public void setBrandId(Short brandId) {
        this.brandId = brandId;
    }

    /**
     * 库存数量
     * @return store_count 库存数量
     */
    public Short getStoreCount() {
        return storeCount;
    }

    /**
     * 库存数量
     * @param storeCount 库存数量
     */
    public void setStoreCount(Short storeCount) {
        this.storeCount = storeCount;
    }

    /**
     * 商品评论数
     * @return comment_count 商品评论数
     */
    public Short getCommentCount() {
        return commentCount;
    }

    /**
     * 商品评论数
     * @param commentCount 商品评论数
     */
    public void setCommentCount(Short commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * 商品重量克为单位
     * @return weight 商品重量克为单位
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 商品重量克为单位
     * @param weight 商品重量克为单位
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 市场价
     * @return market_price 市场价
     */
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    /**
     * 市场价
     * @param marketPrice 市场价
     */
    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * 本店价
     * @return shop_price 本店价
     */
    public BigDecimal getShopPrice() {
        return shopPrice;
    }

    /**
     * 本店价
     * @param shopPrice 本店价
     */
    public void setShopPrice(BigDecimal shopPrice) {
        this.shopPrice = shopPrice;
    }

    /**
     * 商品成本价
     * @return cost_price 商品成本价
     */
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    /**
     * 商品成本价
     * @param costPrice 商品成本价
     */
    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    /**
     * 商品关键词
     * @return keywords 商品关键词
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * 商品关键词
     * @param keywords 商品关键词
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    /**
     * 商品简单描述
     * @return goods_remark 商品简单描述
     */
    public String getGoodsRemark() {
        return goodsRemark;
    }

    /**
     * 商品简单描述
     * @param goodsRemark 商品简单描述
     */
    public void setGoodsRemark(String goodsRemark) {
        this.goodsRemark = goodsRemark == null ? null : goodsRemark.trim();
    }

    /**
     * 商品上传原始图
     * @return original_img 商品上传原始图
     */
    public String getOriginalImg() {
        return originalImg;
    }

    /**
     * 商品上传原始图
     * @param originalImg 商品上传原始图
     */
    public void setOriginalImg(String originalImg) {
        this.originalImg = originalImg == null ? null : originalImg.trim();
    }

    /**
     * 是否为实物
     * @return is_real 是否为实物
     */
    public Byte getIsReal() {
        return isReal;
    }

    /**
     * 是否为实物
     * @param isReal 是否为实物
     */
    public void setIsReal(Byte isReal) {
        this.isReal = isReal;
    }

    /**
     * 是否上架
     * @return is_on_sale 是否上架
     */
    public Boolean getIsOnSale() {
        return isOnSale;
    }

    /**
     * 是否上架
     * @param isOnSale 是否上架
     */
    public void setIsOnSale(Boolean isOnSale) {
        this.isOnSale = isOnSale;
    }

    /**
     * 是否包邮0否1是
     * @return is_free_shipping 是否包邮0否1是
     */
    public Boolean getIsFreeShipping() {
        return isFreeShipping;
    }

    /**
     * 是否包邮0否1是
     * @param isFreeShipping 是否包邮0否1是
     */
    public void setIsFreeShipping(Boolean isFreeShipping) {
        this.isFreeShipping = isFreeShipping;
    }

    /**
     * 商品上架时间
     * @return on_time 商品上架时间
     */
    public Integer getOnTime() {
        return onTime;
    }

    /**
     * 商品上架时间
     * @param onTime 商品上架时间
     */
    public void setOnTime(Integer onTime) {
        this.onTime = onTime;
    }

    /**
     * 商品排序
     * @return sort 商品排序
     */
    public Short getSort() {
        return sort;
    }

    /**
     * 商品排序
     * @param sort 商品排序
     */
    public void setSort(Short sort) {
        this.sort = sort;
    }

    /**
     * 是否推荐
     * @return is_recommend 是否推荐
     */
    public Boolean getIsRecommend() {
        return isRecommend;
    }

    /**
     * 是否推荐
     * @param isRecommend 是否推荐
     */
    public void setIsRecommend(Boolean isRecommend) {
        this.isRecommend = isRecommend;
    }

    /**
     * 是否新品
     * @return is_new 是否新品
     */
    public Boolean getIsNew() {
        return isNew;
    }

    /**
     * 是否新品
     * @param isNew 是否新品
     */
    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    /**
     * 是否热卖
     * @return is_hot 是否热卖
     */
    public Boolean getIsHot() {
        return isHot;
    }

    /**
     * 是否热卖
     * @param isHot 是否热卖
     */
    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    /**
     * 最后更新时间
     * @return last_update 最后更新时间
     */
    public Integer getLastUpdate() {
        return lastUpdate;
    }

    /**
     * 最后更新时间
     * @param lastUpdate 最后更新时间
     */
    public void setLastUpdate(Integer lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * 商品所属类型id，取值表goods_type的cat_id
     * @return goods_type 商品所属类型id，取值表goods_type的cat_id
     */
    public Short getGoodsType() {
        return goodsType;
    }

    /**
     * 商品所属类型id，取值表goods_type的cat_id
     * @param goodsType 商品所属类型id，取值表goods_type的cat_id
     */
    public void setGoodsType(Short goodsType) {
        this.goodsType = goodsType;
    }

    /**
     * 商品规格类型，取值表goods_type的cat_id
     * @return spec_type 商品规格类型，取值表goods_type的cat_id
     */
    public Short getSpecType() {
        return specType;
    }

    /**
     * 商品规格类型，取值表goods_type的cat_id
     * @param specType 商品规格类型，取值表goods_type的cat_id
     */
    public void setSpecType(Short specType) {
        this.specType = specType;
    }

    /**
     * 购买商品赠送积分
     * @return give_integral 购买商品赠送积分
     */
    public Integer getGiveIntegral() {
        return giveIntegral;
    }

    /**
     * 购买商品赠送积分
     * @param giveIntegral 购买商品赠送积分
     */
    public void setGiveIntegral(Integer giveIntegral) {
        this.giveIntegral = giveIntegral;
    }

    /**
     * 积分兑换：0不参与积分兑换，积分和现金的兑换比例见后台配置
     * @return exchange_integral 积分兑换：0不参与积分兑换，积分和现金的兑换比例见后台配置
     */
    public Integer getExchangeIntegral() {
        return exchangeIntegral;
    }

    /**
     * 积分兑换：0不参与积分兑换，积分和现金的兑换比例见后台配置
     * @param exchangeIntegral 积分兑换：0不参与积分兑换，积分和现金的兑换比例见后台配置
     */
    public void setExchangeIntegral(Integer exchangeIntegral) {
        this.exchangeIntegral = exchangeIntegral;
    }

    /**
     * 供货商ID
     * @return suppliers_id 供货商ID
     */
    public Short getSuppliersId() {
        return suppliersId;
    }

    /**
     * 供货商ID
     * @param suppliersId 供货商ID
     */
    public void setSuppliersId(Short suppliersId) {
        this.suppliersId = suppliersId;
    }

    /**
     * 商品销量
     * @return sales_sum 商品销量
     */
    public Integer getSalesSum() {
        return salesSum;
    }

    /**
     * 商品销量
     * @param salesSum 商品销量
     */
    public void setSalesSum(Integer salesSum) {
        this.salesSum = salesSum;
    }

    /**
     * 0 普通订单,1 限时抢购, 2 团购 , 3 促销优惠
     * @return prom_type 0 普通订单,1 限时抢购, 2 团购 , 3 促销优惠
     */
    public Boolean getPromType() {
        return promType;
    }

    /**
     * 0 普通订单,1 限时抢购, 2 团购 , 3 促销优惠
     * @param promType 0 普通订单,1 限时抢购, 2 团购 , 3 促销优惠
     */
    public void setPromType(Boolean promType) {
        this.promType = promType;
    }

    /**
     * 优惠活动id
     * @return prom_id 优惠活动id
     */
    public Integer getPromId() {
        return promId;
    }

    /**
     * 优惠活动id
     * @param promId 优惠活动id
     */
    public void setPromId(Integer promId) {
        this.promId = promId;
    }

    /**
     * 佣金用于分销分成
     * @return commission 佣金用于分销分成
     */
    public BigDecimal getCommission() {
        return commission;
    }

    /**
     * 佣金用于分销分成
     * @param commission 佣金用于分销分成
     */
    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    /**
     * SPU
     * @return spu SPU
     */
    public String getSpu() {
        return spu;
    }

    /**
     * SPU
     * @param spu SPU
     */
    public void setSpu(String spu) {
        this.spu = spu == null ? null : spu.trim();
    }

    /**
     * SKU
     * @return sku SKU
     */
    public String getSku() {
        return sku;
    }

    /**
     * SKU
     * @param sku SKU
     */
    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    /**
     * 商品详细描述
     * @return goods_content 商品详细描述
     */
    public String getGoodsContent() {
        return goodsContent;
    }

    /**
     * 商品详细描述
     * @param goodsContent 商品详细描述
     */
    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent == null ? null : goodsContent.trim();
    }

    /**
     *
     * @mbg.generated 2020-12-31
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsId=").append(goodsId);
        sb.append(", catId=").append(catId);
        sb.append(", extendCatId=").append(extendCatId);
        sb.append(", goodsSn=").append(goodsSn);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", clickCount=").append(clickCount);
        sb.append(", brandId=").append(brandId);
        sb.append(", storeCount=").append(storeCount);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", weight=").append(weight);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", shopPrice=").append(shopPrice);
        sb.append(", costPrice=").append(costPrice);
        sb.append(", keywords=").append(keywords);
        sb.append(", goodsRemark=").append(goodsRemark);
        sb.append(", originalImg=").append(originalImg);
        sb.append(", isReal=").append(isReal);
        sb.append(", isOnSale=").append(isOnSale);
        sb.append(", isFreeShipping=").append(isFreeShipping);
        sb.append(", onTime=").append(onTime);
        sb.append(", sort=").append(sort);
        sb.append(", isRecommend=").append(isRecommend);
        sb.append(", isNew=").append(isNew);
        sb.append(", isHot=").append(isHot);
        sb.append(", lastUpdate=").append(lastUpdate);
        sb.append(", goodsType=").append(goodsType);
        sb.append(", specType=").append(specType);
        sb.append(", giveIntegral=").append(giveIntegral);
        sb.append(", exchangeIntegral=").append(exchangeIntegral);
        sb.append(", suppliersId=").append(suppliersId);
        sb.append(", salesSum=").append(salesSum);
        sb.append(", promType=").append(promType);
        sb.append(", promId=").append(promId);
        sb.append(", commission=").append(commission);
        sb.append(", spu=").append(spu);
        sb.append(", sku=").append(sku);
        sb.append(", goodsContent=").append(goodsContent);
        sb.append("]");
        return sb.toString();
    }
}
