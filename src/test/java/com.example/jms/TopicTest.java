package com.example.jms;

import com.example.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsMessageOperations;
import org.springframework.jms.core.JmsOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import javax.jms.Topic;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by XiuYin.Cui on 2018/4/22.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Example.class)
public class TopicTest {

    @Autowired
    private Topic bootJmsTopic;

    @Autowired
    private JmsMessageOperations jmsMessageOperations;


    @Test
    public void convertAndSend() {
        List<String> list = new ArrayList<>(16);
        list.add("java");
        list.add("python");
        list.add("c++");
        //不能像 队列发送 一样用字符串，字符串的话默认发送的是队列（不存在会新建一个队列）
        jmsMessageOperations.convertAndSend(bootJmsTopic, list);
    }

    @Test
    public void receiveAndConvert() {
        List list = jmsMessageOperations.receiveAndConvert(bootJmsTopic, List.class);
        if (!CollectionUtils.isEmpty(list)) {
            for (Object o : list) {
                System.out.println("--------------" + o + "-----------------");
            }
        }
    }


}
