/*
*
* Order.java
* Copyright(C) 2017-2020 fendo公司
* @date 2021-01-11
*/
package com.choco.order.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Order implements Serializable {
    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 订单编号
     */
    private String orderSn;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 订单状态
     */
    private int orderStatus;

    /**
     * 发货状态
     */
    private Boolean shippingStatus;

    /**
     * 支付状态
     */
    private Boolean payStatus;

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 国家
     */
    private Integer country;

    /**
     * 省份
     */
    private Integer province;

    /**
     * 城市
     */
    private Integer city;

    /**
     * 县区
     */
    private Integer district;

    /**
     * 乡镇
     */
    private Integer twon;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮政编码
     */
    private String zipcode;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 邮件
     */
    private String email;

    /**
     * 物流code
     */
    private String shippingCode;

    /**
     * 物流名称
     */
    private String shippingName;

    /**
     * 支付code
     */
    private String payCode;

    /**
     * 支付方式名称
     */
    private String payName;

    /**
     * 发票抬头
     */
    private String invoiceTitle;

    /**
     * 商品总价
     */
    private BigDecimal goodsPrice;

    /**
     * 邮费
     */
    private BigDecimal shippingPrice;

    /**
     * 使用余额
     */
    private BigDecimal userMoney;

    /**
     * 优惠券抵扣
     */
    private BigDecimal couponPrice;

    /**
     * 使用积分
     */
    private Integer integral;

    /**
     * 使用积分抵多少钱
     */
    private BigDecimal integralMoney;

    /**
     * 应付款金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单总价
     */
    private BigDecimal totalAmount;

    /**
     * 下单时间
     */
    private Integer addTime;

    /**
     * 最后新发货时间
     */
    private Integer shippingTime;

    /**
     * 收货确认时间
     */
    private Integer confirmTime;

    /**
     * 支付时间
     */
    private Integer payTime;

    /**
     * 活动id
     */
    private Short orderPromId;

    /**
     * 活动优惠金额
     */
    private BigDecimal orderPromAmount;

    /**
     * 价格调整
     */
    private BigDecimal discount;

    /**
     * 用户备注
     */
    private String userNote;

    /**
     * 管理员备注
     */
    private String adminNote;

    /**
     * 父单单号
     */
    private String parentSn;

    /**
     * 是否已分成0未分成1已分成
     */
    private Boolean isDistribut;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

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
     * 订单编号
     * @return order_sn 订单编号
     */
    public String getOrderSn() {
        return orderSn;
    }

    /**
     * 订单编号
     * @param orderSn 订单编号
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn == null ? null : orderSn.trim();
    }

    /**
     * 用户id
     * @return user_id 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 订单状态
     * @return order_status 订单状态
     */
    public int getOrderStatus() {
        return orderStatus;
    }

    /**
     * 订单状态
     * @param orderStatus 订单状态
     */
    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 发货状态
     * @return shipping_status 发货状态
     */
    public Boolean getShippingStatus() {
        return shippingStatus;
    }

    /**
     * 发货状态
     * @param shippingStatus 发货状态
     */
    public void setShippingStatus(Boolean shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    /**
     * 支付状态
     * @return pay_status 支付状态
     */
    public Boolean getPayStatus() {
        return payStatus;
    }

    /**
     * 支付状态
     * @param payStatus 支付状态
     */
    public void setPayStatus(Boolean payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * 收货人
     * @return consignee 收货人
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * 收货人
     * @param consignee 收货人
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee == null ? null : consignee.trim();
    }

    /**
     * 国家
     * @return country 国家
     */
    public Integer getCountry() {
        return country;
    }

    /**
     * 国家
     * @param country 国家
     */
    public void setCountry(Integer country) {
        this.country = country;
    }

    /**
     * 省份
     * @return province 省份
     */
    public Integer getProvince() {
        return province;
    }

    /**
     * 省份
     * @param province 省份
     */
    public void setProvince(Integer province) {
        this.province = province;
    }

    /**
     * 城市
     * @return city 城市
     */
    public Integer getCity() {
        return city;
    }

    /**
     * 城市
     * @param city 城市
     */
    public void setCity(Integer city) {
        this.city = city;
    }

    /**
     * 县区
     * @return district 县区
     */
    public Integer getDistrict() {
        return district;
    }

    /**
     * 县区
     * @param district 县区
     */
    public void setDistrict(Integer district) {
        this.district = district;
    }

    /**
     * 乡镇
     * @return twon 乡镇
     */
    public Integer getTwon() {
        return twon;
    }

    /**
     * 乡镇
     * @param twon 乡镇
     */
    public void setTwon(Integer twon) {
        this.twon = twon;
    }

    /**
     * 地址
     * @return address 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 邮政编码
     * @return zipcode 邮政编码
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * 邮政编码
     * @param zipcode 邮政编码
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    /**
     * 手机
     * @return mobile 手机
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机
     * @param mobile 手机
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 邮件
     * @return email 邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮件
     * @param email 邮件
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 物流code
     * @return shipping_code 物流code
     */
    public String getShippingCode() {
        return shippingCode;
    }

    /**
     * 物流code
     * @param shippingCode 物流code
     */
    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode == null ? null : shippingCode.trim();
    }

    /**
     * 物流名称
     * @return shipping_name 物流名称
     */
    public String getShippingName() {
        return shippingName;
    }

    /**
     * 物流名称
     * @param shippingName 物流名称
     */
    public void setShippingName(String shippingName) {
        this.shippingName = shippingName == null ? null : shippingName.trim();
    }

    /**
     * 支付code
     * @return pay_code 支付code
     */
    public String getPayCode() {
        return payCode;
    }

    /**
     * 支付code
     * @param payCode 支付code
     */
    public void setPayCode(String payCode) {
        this.payCode = payCode == null ? null : payCode.trim();
    }

    /**
     * 支付方式名称
     * @return pay_name 支付方式名称
     */
    public String getPayName() {
        return payName;
    }

    /**
     * 支付方式名称
     * @param payName 支付方式名称
     */
    public void setPayName(String payName) {
        this.payName = payName == null ? null : payName.trim();
    }

    /**
     * 发票抬头
     * @return invoice_title 发票抬头
     */
    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    /**
     * 发票抬头
     * @param invoiceTitle 发票抬头
     */
    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    /**
     * 商品总价
     * @return goods_price 商品总价
     */
    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    /**
     * 商品总价
     * @param goodsPrice 商品总价
     */
    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    /**
     * 邮费
     * @return shipping_price 邮费
     */
    public BigDecimal getShippingPrice() {
        return shippingPrice;
    }

    /**
     * 邮费
     * @param shippingPrice 邮费
     */
    public void setShippingPrice(BigDecimal shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    /**
     * 使用余额
     * @return user_money 使用余额
     */
    public BigDecimal getUserMoney() {
        return userMoney;
    }

    /**
     * 使用余额
     * @param userMoney 使用余额
     */
    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    /**
     * 优惠券抵扣
     * @return coupon_price 优惠券抵扣
     */
    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    /**
     * 优惠券抵扣
     * @param couponPrice 优惠券抵扣
     */
    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    /**
     * 使用积分
     * @return integral 使用积分
     */
    public Integer getIntegral() {
        return integral;
    }

    /**
     * 使用积分
     * @param integral 使用积分
     */
    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    /**
     * 使用积分抵多少钱
     * @return integral_money 使用积分抵多少钱
     */
    public BigDecimal getIntegralMoney() {
        return integralMoney;
    }

    /**
     * 使用积分抵多少钱
     * @param integralMoney 使用积分抵多少钱
     */
    public void setIntegralMoney(BigDecimal integralMoney) {
        this.integralMoney = integralMoney;
    }

    /**
     * 应付款金额
     * @return order_amount 应付款金额
     */
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    /**
     * 应付款金额
     * @param orderAmount 应付款金额
     */
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 订单总价
     * @return total_amount 订单总价
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * 订单总价
     * @param totalAmount 订单总价
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * 下单时间
     * @return add_time 下单时间
     */
    public Integer getAddTime() {
        return addTime;
    }

    /**
     * 下单时间
     * @param addTime 下单时间
     */
    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    /**
     * 最后新发货时间
     * @return shipping_time 最后新发货时间
     */
    public Integer getShippingTime() {
        return shippingTime;
    }

    /**
     * 最后新发货时间
     * @param shippingTime 最后新发货时间
     */
    public void setShippingTime(Integer shippingTime) {
        this.shippingTime = shippingTime;
    }

    /**
     * 收货确认时间
     * @return confirm_time 收货确认时间
     */
    public Integer getConfirmTime() {
        return confirmTime;
    }

    /**
     * 收货确认时间
     * @param confirmTime 收货确认时间
     */
    public void setConfirmTime(Integer confirmTime) {
        this.confirmTime = confirmTime;
    }

    /**
     * 支付时间
     * @return pay_time 支付时间
     */
    public Integer getPayTime() {
        return payTime;
    }

    /**
     * 支付时间
     * @param payTime 支付时间
     */
    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    /**
     * 活动id
     * @return order_prom_id 活动id
     */
    public Short getOrderPromId() {
        return orderPromId;
    }

    /**
     * 活动id
     * @param orderPromId 活动id
     */
    public void setOrderPromId(Short orderPromId) {
        this.orderPromId = orderPromId;
    }

    /**
     * 活动优惠金额
     * @return order_prom_amount 活动优惠金额
     */
    public BigDecimal getOrderPromAmount() {
        return orderPromAmount;
    }

    /**
     * 活动优惠金额
     * @param orderPromAmount 活动优惠金额
     */
    public void setOrderPromAmount(BigDecimal orderPromAmount) {
        this.orderPromAmount = orderPromAmount;
    }

    /**
     * 价格调整
     * @return discount 价格调整
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * 价格调整
     * @param discount 价格调整
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    /**
     * 用户备注
     * @return user_note 用户备注
     */
    public String getUserNote() {
        return userNote;
    }

    /**
     * 用户备注
     * @param userNote 用户备注
     */
    public void setUserNote(String userNote) {
        this.userNote = userNote == null ? null : userNote.trim();
    }

    /**
     * 管理员备注
     * @return admin_note 管理员备注
     */
    public String getAdminNote() {
        return adminNote;
    }

    /**
     * 管理员备注
     * @param adminNote 管理员备注
     */
    public void setAdminNote(String adminNote) {
        this.adminNote = adminNote == null ? null : adminNote.trim();
    }

    /**
     * 父单单号
     * @return parent_sn 父单单号
     */
    public String getParentSn() {
        return parentSn;
    }

    /**
     * 父单单号
     * @param parentSn 父单单号
     */
    public void setParentSn(String parentSn) {
        this.parentSn = parentSn == null ? null : parentSn.trim();
    }

    /**
     * 是否已分成0未分成1已分成
     * @return is_distribut 是否已分成0未分成1已分成
     */
    public Boolean getIsDistribut() {
        return isDistribut;
    }

    /**
     * 是否已分成0未分成1已分成
     * @param isDistribut 是否已分成0未分成1已分成
     */
    public void setIsDistribut(Boolean isDistribut) {
        this.isDistribut = isDistribut;
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
        sb.append(", orderId=").append(orderId);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", userId=").append(userId);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", shippingStatus=").append(shippingStatus);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", consignee=").append(consignee);
        sb.append(", country=").append(country);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", twon=").append(twon);
        sb.append(", address=").append(address);
        sb.append(", zipcode=").append(zipcode);
        sb.append(", mobile=").append(mobile);
        sb.append(", email=").append(email);
        sb.append(", shippingCode=").append(shippingCode);
        sb.append(", shippingName=").append(shippingName);
        sb.append(", payCode=").append(payCode);
        sb.append(", payName=").append(payName);
        sb.append(", invoiceTitle=").append(invoiceTitle);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", shippingPrice=").append(shippingPrice);
        sb.append(", userMoney=").append(userMoney);
        sb.append(", couponPrice=").append(couponPrice);
        sb.append(", integral=").append(integral);
        sb.append(", integralMoney=").append(integralMoney);
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", addTime=").append(addTime);
        sb.append(", shippingTime=").append(shippingTime);
        sb.append(", confirmTime=").append(confirmTime);
        sb.append(", payTime=").append(payTime);
        sb.append(", orderPromId=").append(orderPromId);
        sb.append(", orderPromAmount=").append(orderPromAmount);
        sb.append(", discount=").append(discount);
        sb.append(", userNote=").append(userNote);
        sb.append(", adminNote=").append(adminNote);
        sb.append(", parentSn=").append(parentSn);
        sb.append(", isDistribut=").append(isDistribut);
        sb.append("]");
        return sb.toString();
    }
}
