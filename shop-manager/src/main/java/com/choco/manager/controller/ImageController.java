package com.choco.manager.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by choco on 2021/1/7 11:06
 */
@Controller
@RequestMapping("image")
public class ImageController {
    @Autowired
    private DefaultKaptcha kaptcha;

    @GetMapping("code")
    public void getImageCode(HttpServletRequest request, HttpServletResponse response) {
        // 定义response输出类型为image/jpeg类型
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");

        //生成验证码
        String text = kaptcha.createText();
        System.out.println("生成的验证码为--->"+text);
        //把图片验证码放入session
        request.getSession().setAttribute("pictureVerifyKey",text);
        //缓存图片流
        BufferedImage image = kaptcha.createImage(text);

        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            //把图片输出到浏览器
            ImageIO.write(image,"jpg",outputStream);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
