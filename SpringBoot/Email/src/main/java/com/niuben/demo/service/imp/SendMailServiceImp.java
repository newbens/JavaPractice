package com.niuben.demo.service.imp;

import com.niuben.demo.domain.User;
import com.niuben.demo.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class SendMailServiceImp implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public int sendMail(String target, String title, String content, User user) {
        String fromEmail = user.getUsername();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(target);
        message.setSubject(title);
        message.setText(content);
        try {
            javaMailSender.send(message);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }
}
