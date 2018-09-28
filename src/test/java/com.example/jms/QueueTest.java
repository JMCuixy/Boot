package com.example.jms;

import com.example.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsMessageOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XiuYin.Cui on 2018/4/22.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Example.class)
public class QueueTest {


    @Autowired
    private JmsMessageOperations jmsMessageOperations;


    /**
     * jmsMessagingTemplate.convertAndSend() 方法，"bootJmsQueue" 不填写，用默认的 Destination
     */
    @Test
    public void convertAndSend() {
        List<String> list = new ArrayList<>(16);
        list.add("java");
        list.add("python");
        list.add("c++");
        jmsMessageOperations.convertAndSend("bootJmsQueue", list);
    }

    /**
     * jmsMessagingTemplate 的 receiveAndConvert() 方法
     */
    @Test
    public void receiveAndConvert() {
        List list = jmsMessageOperations.receiveAndConvert("bootJmsQueue", List.class);
        if (!CollectionUtils.isEmpty(list)) {
            for (Object o : list) {
                System.out.println("--------------" + o + "-----------------");
            }
        }
    }
}
