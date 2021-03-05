package com.choco.sso;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
@MapperScan("com.choco.sso.mapper")
public class ShopSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopSsoApplication.class, args);
    }

}
