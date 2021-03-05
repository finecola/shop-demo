/*
*
* OrderGoods.java
* Copyright(C) 2017-2020 fendo公司
* @date 2021-01-11
*/
package com.choco.order.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderGoods implements Serializable {
    /**
     * 表id自增
     */
    private Integer recId;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 视频名称
     */
    private String goodsName;

    /**
     * 商品货号
     */
    private String goodsSn;

    /**
     * 购买数量
     */
    private Short goodsNum;

    /**
     * 市场价
     */
    private BigDecimal marketPrice;

    /**
     * 本店价
     */
    private BigDecimal goodsPrice;

    /**
     * 商品成本价
     */
    private BigDecimal costPrice;

    /**
     * 会员折扣价
     */
    private BigDecimal memberGoodsPrice;

    /**
     * 购买商品赠送积分
     */
    private Integer giveIntegral;

    /**
     * 商品规格key
     */
    private String specKey;

    /**
     * 规格对应的中文名字
     */
    private String specKeyName;

    /**
     * 条码
     */
    private String barCode;

    /**
     * 是否评价
     */
    private Boolean isComment;

    /**
     * 0 普通订单,1 限时抢购, 2 团购 , 3 促销优惠
     */
    private Boolean promType;

    /**
     * 活动id
     */
    private Integer promId;

    /**
     * 0未发货，1已发货，2已换货，3已退货
     */
    private Boolean isSend;

    /**
     * 发货单ID
     */
    private Integer deliveryId;

    /**
     * sku
     */
    private String sku;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 表id自增
     * @return rec_id 表id自增
     */
    public Integer getRecId() {
        return recId;
    }

    /**
     * 表id自增
     * @param recId 表id自增
     */
    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    /**
     * 订单id
     * @return order_id 订单id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 订单id
     * @param orderId 订单id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

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
     * 视频名称
     * @return goods_name 视频名称
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * 视频名称
     * @param goodsName 视频名称
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * 商品货号
     * @return goods_sn 商品货号
     */
    public String getGoodsSn() {
        return goodsSn;
    }

    /**
     * 商品货号
     * @param goodsSn 商品货号
     */
    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn == null ? null : goodsSn.trim();
    }

    /**
     * 购买数量
     * @return goods_num 购买数量
     */
    public Short getGoodsNum() {
        return goodsNum;
    }

    /**
     * 购买数量
     * @param goodsNum 购买数量
     */
    public void setGoodsNum(Short goodsNum) {
        this.goodsNum = goodsNum;
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
     * @return goods_price 本店价
     */
    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    /**
     * 本店价
     * @param goodsPrice 本店价
     */
    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
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
     * 会员折扣价
     * @return member_goods_price 会员折扣价
     */
    public BigDecimal getMemberGoodsPrice() {
        return memberGoodsPrice;
    }

    /**
     * 会员折扣价
     * @param memberGoodsPrice 会员折扣价
     */
    public void setMemberGoodsPrice(BigDecimal memberGoodsPrice) {
        this.memberGoodsPrice = memberGoodsPrice;
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
     * 商品规格key
     * @return spec_key 商品规格key
     */
    public String getSpecKey() {
        return specKey;
    }

    /**
     * 商品规格key
     * @param specKey 商品规格key
     */
    public void setSpecKey(String specKey) {
        this.specKey = specKey == null ? null : specKey.trim();
    }

    /**
     * 规格对应的中文名字
     * @return spec_key_name 规格对应的中文名字
     */
    public String getSpecKeyName() {
        return specKeyName;
    }

    /**
     * 规格对应的中文名字
     * @param specKeyName 规格对应的中文名字
     */
    public void setSpecKeyName(String specKeyName) {
        this.specKeyName = specKeyName == null ? null : specKeyName.trim();
    }

    /**
     * 条码
     * @return bar_code 条码
     */
    public String getBarCode() {
        return barCode;
    }

    /**
     * 条码
     * @param barCode 条码
     */
    public void setBarCode(String barCode) {
        this.barCode = barCode == null ? null : barCode.trim();
    }

    /**
     * 是否评价
     * @return is_comment 是否评价
     */
    public Boolean getIsComment() {
        return isComment;
    }

    /**
     * 是否评价
     * @param isComment 是否评价
     */
    public void setIsComment(Boolean isComment) {
        this.isComment = isComment;
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
     * 活动id
     * @return prom_id 活动id
     */
    public Integer getPromId() {
        return promId;
    }

    /**
     * 活动id
     * @param promId 活动id
     */
    public void setPromId(Integer promId) {
        this.promId = promId;
    }

    /**
     * 0未发货，1已发货，2已换货，3已退货
     * @return is_send 0未发货，1已发货，2已换货，3已退货
     */
    public Boolean getIsSend() {
        return isSend;
    }

    /**
     * 0未发货，1已发货，2已换货，3已退货
     * @param isSend 0未发货，1已发货，2已换货，3已退货
     */
    public void setIsSend(Boolean isSend) {
        this.isSend = isSend;
    }

    /**
     * 发货单ID
     * @return delivery_id 发货单ID
     */
    public Integer getDeliveryId() {
        return deliveryId;
    }

    /**
     * 发货单ID
     * @param deliveryId 发货单ID
     */
    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    /**
     * sku
     * @return sku sku
     */
    public String getSku() {
        return sku;
    }

    /**
     * sku
     * @param sku sku
     */
    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    /**
     *
     * @mbg.generated 2021-01-11
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", recId=").append(recId);
        sb.append(", orderId=").append(orderId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsSn=").append(goodsSn);
        sb.append(", goodsNum=").append(goodsNum);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", costPrice=").append(costPrice);
        sb.append(", memberGoodsPrice=").append(memberGoodsPrice);
        sb.append(", giveIntegral=").append(giveIntegral);
        sb.append(", specKey=").append(specKey);
        sb.append(", specKeyName=").append(specKeyName);
        sb.append(", barCode=").append(barCode);
        sb.append(", isComment=").append(isComment);
        sb.append(", promType=").append(promType);
        sb.append(", promId=").append(promId);
        sb.append(", isSend=").append(isSend);
        sb.append(", deliveryId=").append(deliveryId);
        sb.append(", sku=").append(sku);
        sb.append("]");
        return sb.toString();
    }
}
