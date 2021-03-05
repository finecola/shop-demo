package com.choco.portal.config;

import com.choco.portal.interceptor.PortalCommonInterceptor;
import com.choco.portal.interceptor.PortalLoginInterceptor;
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
    private PortalLoginInterceptor loginInterceptor;
    @Autowired
    private PortalCommonInterceptor commonInterceptor;
    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonInterceptor)
                .addPathPatterns("/**");

        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/search/**","/user/toLogin","/static/**","/login","/user/login","/user/logout","/index");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
