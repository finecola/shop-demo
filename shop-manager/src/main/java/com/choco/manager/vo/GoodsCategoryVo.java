/*
 *
 * Goodsategory.java
 * Copyright(C) 2017-2020 fendo公司
 * @date 2020-12-28
 */
package com.choco.manager.vo;

import java.io.Serializable;
import java.util.List;

public class GoodsCategoryVo implements Serializable {
    /**
     * 商品的下级list
     */
    private List<GoodsCategoryVo> children;

    /**
     * 商品分类id
     */
    private Short id;

    /**
     * 商品分类名称
     */
    private String name;

    /**
     * 手机端显示的商品分类名
     */
    private String mobileName;

    /**
     * 父id
     */
    private Short parentId;

    /**
     * 家族图谱
     */
    private String parentIdPath;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 顺序排序
     */
    private Integer sortOrder;

    /**
     * 是否显示
     */
    private Boolean isShow;

    /**
     * 分类图片
     */
    private String image;

    /**
     * 是否推荐为热门分类
     */
    private Boolean isHot;

    /**
     * 分类分组默认0
     */
    private Integer catGroup;

    /**
     * 分佣比例
     */
    private Boolean commissionRate;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 获取商品的二级List
     *
     * @return
     */
    public List<GoodsCategoryVo> getChildren() {
        return children;
    }

    /**
     * 设置商品的二级List
     *
     * @return
     */
    public void setChildren(List<GoodsCategoryVo> children) {
        this.children = children;
    }

    /**
     * 商品分类id
     *
     * @return id 商品分类id
     */
    public Short getId() {
        return id;
    }

    /**
     * 商品分类id
     *
     * @param id 商品分类id
     */
    public void setId(Short id) {
        this.id = id;
    }

    /**
     * 商品分类名称
     *
     * @return name 商品分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 商品分类名称
     *
     * @param name 商品分类名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 手机端显示的商品分类名
     *
     * @return mobile_name 手机端显示的商品分类名
     */
    public String getMobileName() {
        return mobileName;
    }

    /**
     * 手机端显示的商品分类名
     *
     * @param mobileName 手机端显示的商品分类名
     */
    public void setMobileName(String mobileName) {
        this.mobileName = mobileName == null ? null : mobileName.trim();
    }

    /**
     * 父id
     *
     * @return parent_id 父id
     */
    public Short getParentId() {
        return parentId;
    }

    /**
     * 父id
     *
     * @param parentId 父id
     */
    public void setParentId(Short parentId) {
        this.parentId = parentId;
    }

    /**
     * 家族图谱
     *
     * @return parent_id_path 家族图谱
     */
    public String getParentIdPath() {
        return parentIdPath;
    }

    /**
     * 家族图谱
     *
     * @param parentIdPath 家族图谱
     */
    public void setParentIdPath(String parentIdPath) {
        this.parentIdPath = parentIdPath == null ? null : parentIdPath.trim();
    }

    /**
     * 等级
     *
     * @return level 等级
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 等级
     *
     * @param level 等级
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 顺序排序
     *
     * @return sort_order 顺序排序
     */
    public Integer getSortOrder() {
        return sortOrder;
    }

    /**
     * 顺序排序
     *
     * @param sortOrder 顺序排序
     */
    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * 是否显示
     *
     * @return is_show 是否显示
     */
    public Boolean getIsShow() {
        return isShow;
    }

    /**
     * 是否显示
     *
     * @param isShow 是否显示
     */
    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    /**
     * 分类图片
     *
     * @return image 分类图片
     */
    public String getImage() {
        return image;
    }

    /**
     * 分类图片
     *
     * @param image 分类图片
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * 是否推荐为热门分类
     *
     * @return is_hot 是否推荐为热门分类
     */
    public Boolean getIsHot() {
        return isHot;
    }

    /**
     * 是否推荐为热门分类
     *
     * @param isHot 是否推荐为热门分类
     */
    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    /**
     * 分类分组默认0
     *
     * @return cat_group 分类分组默认0
     */
    public Integer getCatGroup() {
        return catGroup;
    }

    /**
     * 分类分组默认0
     *
     * @param catGroup 分类分组默认0
     */
    public void setCatGroup(Integer catGroup) {
        this.catGroup = catGroup;
    }

    /**
     * 分佣比例
     *
     * @return commission_rate 分佣比例
     */
    public Boolean getCommissionRate() {
        return commissionRate;
    }

    /**
     * 分佣比例
     *
     * @param commissionRate 分佣比例
     */
    public void setCommissionRate(Boolean commissionRate) {
        this.commissionRate = commissionRate;
    }

    /**
     * @mbg.generated 2020-12-28
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", mobileName=").append(mobileName);
        sb.append(", parentId=").append(parentId);
        sb.append(", parentIdPath=").append(parentIdPath);
        sb.append(", level=").append(level);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", isShow=").append(isShow);
        sb.append(", image=").append(image);
        sb.append(", isHot=").append(isHot);
        sb.append(", catGroup=").append(catGroup);
        sb.append(", commissionRate=").append(commissionRate);
        sb.append("]");
        return sb.toString();
    }
}
