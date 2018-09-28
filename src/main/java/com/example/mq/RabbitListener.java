package com.example.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 这里注释掉 RabbitMQ 的配置，因为两个消息代理（ActiveMQ）在一起，冲突和bug很多。
 */
//@Component
public class RabbitListener {

    private static final Logger logger = LoggerFactory.getLogger(RabbitListener.class);

    /**
     * RabbitMQ 的队列监听器
     * @param list
     * @param <E>
     */
    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "bootQueue")
    public <E> void rabbitListener(List<E> list){
        if (!CollectionUtils.isEmpty(list)){
            for (E e : list){
                logger.info("----------"+ e +"-----------");
            }
        }
    }

}
