package com.example.email;

import com.example.Example;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Example.class)
public class SendTest {


    @Autowired
    private JavaMailSender javaMailSender;

    private VelocityEngine velocityEngine;


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

    /**
     * 附件发送
     */
    @Test
    public void mimeEmail() throws MessagingException {
        // MimeMessage 本身的 API 有些笨重，我们可以使用 MimeMessageHelper
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        // 第二个参数是 true ，表明这个消息是 multipart类型的/
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("15980292662@163.com");
        mimeMessageHelper.setTo("cuixiuyin@qianxx.com");
        mimeMessageHelper.setSubject("附件邮件主题");
        mimeMessageHelper.setText("附件邮件内容");
        //添加附件,第一个参数表示添加到 Email 中附件的名称，第二个参数是图片资源
        mimeMessageHelper.addAttachment("boot.png", new ClassPathResource("public/images/boot.png"));
        javaMailSender.send(mimeMessage);
    }

    /**
     * 富文本发送
     */
    @Test
    public void htmlEmail() throws MessagingException {
        // MimeMessage 本身的 API 有些笨重，我们可以使用 MimeMessageHelper
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        // 第二个参数是 true ，表明这个消息是 multipart类型的/
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setFrom("15980292662@163.com");
        mimeMessageHelper.setTo("cuixiuyin@qianxx.com");
        mimeMessageHelper.setSubject("附件邮件主题");
        // 设置内嵌元素 cid，第一个参数表示 内联图片的标识符，第二个参数标识资源引用
        mimeMessageHelper.addInline("boot", new ClassPathResource("public/images/boot.png"));
        String html = "<html><body><h4>Hello,SpringBoot</h4><img src='cid:boot' /></body></html>";
        mimeMessageHelper.setText(html, true);
        // 设置内嵌元素 cid，第一个参数表示 内联图片的标识符，第二个参数标识资源引用
        mimeMessageHelper.addInline("boot", new ClassPathResource("public/images/boot.png"));
        //添加附件,第一个参数表示添加到 Email 中附件的名称，第二个参数是图片资源
        mimeMessageHelper.addAttachment("boot.png", new ClassPathResource("public/images/boot.png"));
        javaMailSender.send(mimeMessage);
    }


}
