package com.choco.manager.config;

import com.choco.manager.interceptor.ManagerLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by choco on 2021/1/6 13:12
 */
@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    @Autowired
    private ManagerLoginInterceptor loginInterceptor;
    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/image/**","/user/toLogin/**","/static/**","/login/**","/user/login/**","/user/logout/**","/index/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/login/**").addResourceLocations("classpath:/templates/login.ftl");
    }
}
