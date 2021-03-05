package com.choco.order.config;

import com.choco.order.interceptor.OrderCommonInterceptor;
import com.choco.order.interceptor.OrderLoginInterceptor;
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

    public static void main(String[] args) {
        String a = new String("a");
        String intern = a.intern();
    }

    @Autowired
    private OrderLoginInterceptor orderLoginInterceptor;
    @Autowired
    private OrderCommonInterceptor commonInterceptor;
    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonInterceptor)
                .addPathPatterns("/**");

        registry.addInterceptor(orderLoginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/image/**","/user/toLogin/**","/static/**","/login/**","/user/login/**","/user/logout/**","/index/**");
    }

    /**
     * 静态资源过滤
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/login/**").addResourceLocations("classpath:/templates/login.ftl");
    }
}
