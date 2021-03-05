package com.choco.portal.service.impl;

import com.choco.common.utils.CookieUtil;
import com.choco.portal.service.CookieService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by choco on 2021/1/6 11:16
 */
@Service
public class CookieServiceImpl implements CookieService {
    @Override
    public boolean setCookie(HttpServletRequest request, HttpServletResponse response, String ticket) {
        try {
            //cookieName 已经预先定义好了
            CookieUtil.setCookie(request,response,"userTicket",ticket);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getCookie(HttpServletRequest request) {
        //huo
        String ticket = CookieUtil.getCookieValue(request, "userTicket");
        return ticket;
    }

    @Override
    public boolean deleteCookie(HttpServletRequest request,HttpServletResponse response) {
        try {
            CookieUtil.deleteCookie(request,response,"userTicket");
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
