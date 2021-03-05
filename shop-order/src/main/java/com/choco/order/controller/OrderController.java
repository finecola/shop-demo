package com.choco.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.choco.common.entity.Admin;
import com.choco.common.result.BaseResult;
import com.choco.order.config.AlipayConfig;
import com.choco.order.entity.Order;
import com.choco.order.service.impl.OrderServiceImpl;
import com.choco.rpc.service.CartService;
import com.choco.rpc.vo.CartResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

/**
 * Created by choco on 2021/1/11 16:29
 */
@Controller
@RequestMapping("order")
public class OrderController {
    @Reference(interfaceClass = CartService.class)
    private CartService cartService;
    @Autowired
    private OrderServiceImpl orderService;

    /**
     * 跳转到预订单
     *
     * @param model
     * @param request
     * @return
     */
    @GetMapping("preOrder")
    public String toPreOrder(Model model, HttpServletRequest request) {
        //获取admin
        Admin admin = (Admin) request.getSession().getAttribute("user");
        //获取cartResult
        model.addAttribute("cartResult", cartService.getCartList(admin));
        return "order/preOrder";
    }

    /**
     * 跳转到提交订单页
     *
     * @param request
     * @param model
     * @return
     */
    @PostMapping("submitOrder")
    public String submitOrder(HttpServletRequest request, Model model) {
        Admin admin = (Admin) request.getSession().getAttribute("user");
        //获取CartResult
        CartResult cartResult = cartService.getCartList(admin);
        //1.存入订单信息
        BaseResult baseResult = orderService.orderSave(admin, cartResult);
        //2.清除购物车信息
        cartService.clearCart(admin);
        //3.返回订单编号
        model.addAttribute("orderSn", baseResult.getMessage());
        //获取总价
        BigDecimal totalPrice = cartResult.getTotalPrice();
        //返回前端
        model.addAttribute("totalPrice", totalPrice);
        return "order/submitOrder";
    }

    /**
     * 支付完成后,回到我的订单页
     *
     * @return
     */
    @GetMapping("myOrder")
    public String myOrder() {
        return "order/myOrder";
    }

    /**
     * 支付方法,进入ali的支付页面
     *
     * @param request
     * @return
     */
    @RequestMapping("payment")
    public String payment(HttpServletRequest request, Model model, String orderSn) throws UnsupportedEncodingException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //查询出order
        Order order = orderService.selectOrderByOrderSn(orderSn);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = orderSn;
        //付款金额，必填
        String total_amount = String.valueOf(order.getTotalAmount());
        //订单名称，必填
        String subject = "用户的订单" + order.getOrderId();
        //商品描述，可空
        String body = "";
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //请求
        String result = null;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
            model.addAttribute("result", result);
            System.out.println(result);
            return "order/payment";
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
    }
}
