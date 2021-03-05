/*
*
* GoodsImage.java
* Copyright(C) 2017-2020 fendo公司
* @date 2021-01-01
*/
package com.choco.manager.entity;

import java.io.Serializable;

public class GoodsImage implements Serializable {
    /**
     * 图片id 自增
     */
    private Integer imgId;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 图片地址
     */
    private String imageUrl;

    /**
     * 序列化id
     */
    private static final long serialVersionUID = 1L;

    /**
     * 图片id 自增
     * @return img_id 图片id 自增
     */
    public Integer getImgId() {
        return imgId;
    }

    /**
     * 图片id 自增
     * @param imgId 图片id 自增
     */
    public void setImgId(Integer imgId) {
        this.imgId = imgId;
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
     * 图片地址
     * @return image_url 图片地址
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 图片地址
     * @param imageUrl 图片地址
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    /**
     *
     * @mbg.generated 2021-01-01
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", imgId=").append(imgId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append("]");
        return sb.toString();
    }
}
