package com.choco.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by choco on 2021/1/11 21:57
 */
@Controller
@RequestMapping("search")
public class SearchController {
    /**
     * 跳转搜索页面
     * @return
     */
    @RequestMapping("index")
    @ResponseBody
    public String index(HttpServletRequest request, String keyword){
        try {
            String encodeKeyword = URLEncoder.encode(keyword,"utf-8");
            return "redirect:"+request.getSession().getAttribute("portalUrl")+"search/index?keyword="+encodeKeyword;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
