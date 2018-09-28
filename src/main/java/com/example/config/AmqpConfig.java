package com.example.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 这里注释掉 RabbitMQ 的配置，因为两个消息代理（ActiveMQ）在一起，冲突和bug很多。
 */
//@Configuration
public class AmqpConfig {

    /**
     * 声明队列
     */
    @Bean
    public Queue bootQueue() {
        return new Queue("bootQueue");
    }

    /**
     * 声明 Exchange
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange("headersExchange");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 声明 Binding
     */
    @Bean
    public Binding bindingDirectExchange(Queue bootQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(bootQueue).to(directExchange).with("bootQueue");
    }

    @Bean
    public Binding bindingTopicExchange(Queue bootQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(bootQueue).to(topicExchange).with("routing.*");
    }

    @Bean
    public Binding bindingHeadersExchange(Queue bootQueue, HeadersExchange headersExchange) {
        Map<String, Object> map = new HashMap<>();
        map.put("betty", "rubble");
        map.put("barney", "rubble");
        //whereAny表示部分匹配，whereAll表示全部匹配
        // return BindingBuilder.bind(bootQueue).to(headersExchange).whereAll(map).match();
        return BindingBuilder.bind(bootQueue).to(headersExchange).whereAny(map).match();
    }

    @Bean
    public Binding FanoutExchange(Queue bootQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(bootQueue).to(fanoutExchange);
    }
}
