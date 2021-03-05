package com.choco.portal.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by choco on 2021/1/17 9:47
 */
@Configuration
public class rabbitmqConfig {
    /**
     * 不要导错包,声明队列
     * @return
     */
    @Bean
    public Queue queue(){
        return new Queue("smsQueue");
    }

    /**
     * 声明主题模式交换机
     * @return
     */
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("smsExchange");
    }

    /**
     * 队列绑定到交换机,并给队列添加路由key
     * @return
     */
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(topicExchange()).with("*.msg");
    }
}
