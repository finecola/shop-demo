package com.choco.portal.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by choco on 2021/1/11 16:16
 */
@Component
public class PortalCommonInterceptor implements HandlerInterceptor {
    @Value("shop.order.url")
    private String shopOrderUrl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ServletContext servletContext = request.getSession().getServletContext();
        String orderUrl = (String) servletContext.getAttribute("orderUrl");
        //加上if判断, 否则每次拦截都要设置属性
        if (StringUtils.isEmpty(orderUrl)){
            servletContext.setAttribute("orderUrl", shopOrderUrl);
        }
        return true;
    }
}
