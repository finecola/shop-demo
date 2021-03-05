package com.choco.portal.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by choco on 2021/1/17 10:30
 */
@Component
@RabbitListener(queues = "smsQueue")
public class SmsConsumer {
    @Reference(interfaceClass = SMSService.class)
    private SMSService smsService;

    @RabbitHandler
    public void recv(String phoneNum){
        System.out.println("接收消息-->"+message);
        smsService.sendMessage(phoneNum);
    }
}
