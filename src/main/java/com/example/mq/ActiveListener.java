package com.example.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class ActiveListener {

    private static final Logger logger = LoggerFactory.getLogger(ActiveListener.class);

    /**
     * 队列监听器
     *
     * @param list
     * @param <E>
     */
    @JmsListener(destination = "bootJmsQueue")
    public <E> void queueListener(List<E> list) {
        if (!CollectionUtils.isEmpty(list)) {
            for (E e : list) {
                logger.info("----------" + e + "-----------");
            }
        }
    }

    /**
     * 主题监听器
     *
     * @param list
     * @param <E>
     */
    @JmsListener(destination = "bootJmsTopic", containerFactory = "jmsListenerContainerTopic")
    public <E> void topicListener1(List<E> list) {
        if (!CollectionUtils.isEmpty(list)) {
            for (E e : list) {
                logger.info("----------" + e + "-----------");
            }
        }
    }

    /**
     * 主题监听器
     *
     * @param list
     * @param <E>
     */
    @JmsListener(destination = "bootJmsTopic", containerFactory = "jmsListenerContainerTopic")
    public <E> void topicListener2(List<E> list) {
        if (!CollectionUtils.isEmpty(list)) {
            for (E e : list) {
                logger.info("----------" + e + "-----------");
            }
        }
    }


}
