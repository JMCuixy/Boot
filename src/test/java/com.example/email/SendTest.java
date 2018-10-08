package com.example.email;

import com.example.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Example.class)
public class SendTest {


    @Autowired
    private JavaMailSender javaMailSender;


    @Test
    public void sendSimpleEmail() {
        // 构造Email消息
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("15980292662@163.com");
        message.setTo("cuixiuyin@qianxx.com");
        message.setSubject("邮件主题");
        message.setText("邮件内容");
        javaMailSender.send(message);
    }

}
