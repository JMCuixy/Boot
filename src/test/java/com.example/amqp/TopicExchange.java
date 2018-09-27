package com.example.amqp;

import com.example.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class TopicExchange {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    public void convertAndSend() {
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("python");
        list.add("c++");
        rabbitTemplate.convertAndSend("topicExchange", "routing.123", list);
    }


    @Test
    public void receiveAndConvert() {
        List<String> queue2List = (List) rabbitTemplate.receiveAndConvert("queue2");
        printList(queue2List);

    }


    private <E> void printList(List<E> list) {
        if (list != null && list.size() > 0) {
            for (E o : list) {
                System.out.println("-----------------" + o + "---------------");
            }
        }
    }
}
