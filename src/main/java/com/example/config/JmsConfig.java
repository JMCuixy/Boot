package com.example.config;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class JmsConfig {

    @Value("${spring.activemq.user}")
    private String usrName;

    @Value("${spring.activemq.password}")
    private String password;

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Value("${spring.activemq.packages.trust-all}")
    private Boolean trustAllPackages;

    @Value("${spring.activemq.pool.max-connections}")
    private Integer maxThreadPoolSize;

    /**
     * 创建队列
     *
     * @return
     */
    @Bean
    public Queue bootJmsQueue() {
        return new ActiveMQQueue("bootJmsQueue");
    }

    /**
     * 创建主题
     *
     * @return
     */
    @Bean
    public Topic bootJmsTopic() {
        return new ActiveMQTopic("bootJmsTopic");
    }

    /**
     * 连接工厂
     *
     * @return
     */
    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(usrName, password, brokerUrl);
        activeMQConnectionFactory.setTrustAllPackages(trustAllPackages);
        activeMQConnectionFactory.setMaxThreadPoolSize(maxThreadPoolSize);
        return activeMQConnectionFactory;
    }

    /**
     * 为 主题/订阅模式 生成新的 JmsListenerContainerFactory，默认的仅支持 point-point 点对点模式
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }


}
