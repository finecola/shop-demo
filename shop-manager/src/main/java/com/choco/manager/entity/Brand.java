/*
*
* Brand.java
* Copyright(C) 2017-2020 fendo公司
* @date 2020-12-31
*/
package com.choco.manager.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class Brand implements Serializable {
    /**
     * 品牌表
     */
    private Short id;

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 品牌logo
     */
    private String logo;

    /**
     * 品牌地址
     */
    private String url;

    /**
     * 排序
     */
    private Byte sort;

    /**
     * 品牌分类
     */
    private String catName;

    /**
     * 父品牌分类id
     */
    private Integer parentCatId;

    /**
     * 分类id
     */
    private Integer catId;

    /**
     * 是否推荐
     */
    private byte isHot;

    /**
     * 品牌描述
     */
    private String desc;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 品牌表
     * @return id 品牌表
     */
    public Short getId() {
        return id;
    }

    /**
     * 品牌表
     * @param id 品牌表
     */
    public void setId(Short id) {
        this.id = id;
    }

    /**
     * 品牌名称
     * @return name 品牌名称
     */
    public String getName() {
        return name;
    }

    /**
     * 品牌名称
     * @param name 品牌名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 品牌logo
     * @return logo 品牌logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * 品牌logo
     * @param logo 品牌logo
     */
    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    /**
     * 品牌地址
     * @return url 品牌地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 品牌地址
     * @param url 品牌地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 排序
     * @return sort 排序
     */
    public Byte getSort() {
        return sort;
    }

    /**
     * 排序
     * @param sort 排序
     */
    public void setSort(Byte sort) {
        this.sort = sort;
    }

    /**
     * 品牌分类
     * @return cat_name 品牌分类
     */
    public String getCatName() {
        return catName;
    }

    /**
     * 品牌分类
     * @param catName 品牌分类
     */
    public void setCatName(String catName) {
        this.catName = catName == null ? null : catName.trim();
    }

    /**
     * 分类id
     * @return parent_cat_id 分类id
     */
    public Integer getParentCatId() {
        return parentCatId;
    }

    /**
     * 分类id
     * @param parentCatId 分类id
     */
    public void setParentCatId(Integer parentCatId) {
        this.parentCatId = parentCatId;
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
     * 是否推荐
     * @return is_hot 是否推荐
     */
    public byte getIsHot() {
        return isHot;
    }

    /**
     * 是否推荐
     * @param isHot 是否推荐
     */
    public void setIsHot(byte isHot) {
        this.isHot = isHot;
    }

    /**
     * 品牌描述
     * @return desc 品牌描述
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 品牌描述
     * @param desc 品牌描述
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
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
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", logo=").append(logo);
        sb.append(", url=").append(url);
        sb.append(", sort=").append(sort);
        sb.append(", catName=").append(catName);
        sb.append(", parentCatId=").append(parentCatId);
        sb.append(", catId=").append(catId);
        sb.append(", isHot=").append(isHot);
        sb.append(", desc=").append(desc);
        sb.append("]");
        return sb.toString();
    }
}
