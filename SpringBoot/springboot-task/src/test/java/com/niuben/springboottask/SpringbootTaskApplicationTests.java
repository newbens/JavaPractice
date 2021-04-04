package com.niuben.springboottask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringbootTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Test//简单邮件发送
    void contextLoads() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //邮件设置
        simpleMailMessage.setSubject("有内鬼终止交易！");
        simpleMailMessage.setText("下次交易时间，等我通知");
        simpleMailMessage.setTo("1099309446@qq.com");
        simpleMailMessage.setFrom("newbens@163.com");
        javaMailSender.send(simpleMailMessage);
    }

    @Test//复杂邮件发送
    public void test2() throws MessagingException {
        //创建复杂邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setSubject("WDNMD");
        mimeMessageHelper.setText("<b style='color:red'>别骂了别骂了</b>",true);  //可以兼容HTML
        mimeMessageHelper.setFrom("newbens@163.com");
        mimeMessageHelper.setTo("1099309446@qq.com");
        mimeMessageHelper.addAttachment("1.png",new File("C:\\Users\\lenovo-pc\\Desktop\\JavaEE作业\\作业4\\1.png"));
        javaMailSender.send(mimeMessage);

    }


}
