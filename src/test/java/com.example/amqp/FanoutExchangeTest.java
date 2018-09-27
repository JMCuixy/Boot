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
 * Created by XiuYin.Cui on 2018/4/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Example.class)
public class FanoutExchangeTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void convertAndSend(){
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("python");
        list.add("c++");
        rabbitTemplate.convertAndSend("fanoutExchange", "任意的Routing key", list);
    }

    @Test
    public void receiveAndConvert(){
        Object bootQueue = rabbitTemplate.receiveAndConvert("bootQueue");
        printList((List)bootQueue);
    }


    private <E> void printList(List<E> list){
        if (list != null && list.size() > 0){
            for (E o : list){
                System.out.println("-----------------"+ o +"---------------");
            }
        }
    }
}
