package com.choco.rpc;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.choco.rpc.mapper")
@EnableDubbo
public class ShopRpcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopRpcApplication.class, args);
    }

}
