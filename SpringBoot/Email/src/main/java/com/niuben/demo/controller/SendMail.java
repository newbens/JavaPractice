package com.niuben.demo.controller;

import com.niuben.demo.domain.User;
import com.niuben.demo.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class SendMail {

    @Autowired
    SendMailService sendMailService;

    @GetMapping("/sendemail")
    public String sendmail() {
        return "send";
    }

    @PostMapping("/send")
    public String send(@RequestParam String target, @RequestParam String title, @RequestParam String content,
                       RedirectAttributes attributes, HttpSession session) {
        User user = (User) session.getAttribute("user");
        int i = sendMailService.sendMail(target, title, content, user);
        if(i == 1) {
            attributes.addFlashAttribute("message", "发送成功！");
        }else {
            attributes.addFlashAttribute("message", "发送失败！");
        }
        return "redirect:/sendemail";
    }
}
