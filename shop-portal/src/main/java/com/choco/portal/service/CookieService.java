package com.choco.portal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by choco on 2021/1/6 11:15
 */
public interface CookieService {
    /**
     * 设置用户cookie
     * @param request
     * @param response
     * @param ticket
     * @return
     */
    boolean setCookie(HttpServletRequest request, HttpServletResponse response,String ticket);

    /**
     * 获取cookie
     * @ request
     */
    String getCookie(HttpServletRequest request);

    /**
     * 删除cookie
     */
    boolean deleteCookie(HttpServletRequest request,HttpServletResponse response);
}
