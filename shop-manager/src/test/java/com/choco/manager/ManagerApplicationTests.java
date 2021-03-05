package com.choco.manager;

import com.choco.manager.service.GoodsCategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ManagerApplicationTests {
    @Autowired
    public GoodsCategoryService goodsCategoryService;

    @Test
    void contextLoads() {

    }

}
