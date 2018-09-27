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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XiuYin.Cui on 2018/4/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Example.class)
public class DirectExchangeTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void send() {
        Message message = new Message("Hello Rabbit".getBytes(), new MessageProperties());
        rabbitTemplate.send("directExchange", "bootQueue", message);
    }

    @Test
    public void receive() {
        Message message = rabbitTemplate.receive("bootQueue");
        System.out.println("---------------------" + new String(message.getBody()));

    }


    /*------------------------------------------------------------*/

    @Test
    public void convertAndSend() {
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("python");
        list.add("c++");
        rabbitTemplate.convertAndSend("directExchange", "bootQueue", list);
    }


    /**
     * 调用receive()和receiveAndConvert()方法都会立即返回，如果队列中没有等待的消息时，将会得到null
     */
    @Test
    public void receiveAndConvret() {
        List<String> list = (List) rabbitTemplate.receiveAndConvert("bootQueue");
        for (String str : list) {
            System.out.println(str);
        }
    }


}
