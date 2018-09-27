package com.example.amqp;

import com.example.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by XiuYin.Cui on 2018/4/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Example.class)
public class HeadersExchangeTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void convertAndSend(){
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("betty", "rubble");
        messageProperties.setHeader("fred", "flintstone");
        messageProperties.setHeader("barney", "rubble");

        String str = new String("Hello RabbitMQ");
        Message message = new Message(str.getBytes(), messageProperties);
        rabbitTemplate.convertAndSend("headersExchange","",message);
    }

    @Test
    public void receiveAndConvert(){

        Message bootQueue = rabbitTemplate.receive("bootQueue");
        System.out.println("第一个输出：" + new String(bootQueue.getBody()));

    }

}
