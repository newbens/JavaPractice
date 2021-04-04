package com.niuben.demo.controller;

import com.niuben.demo.domain.User;
import com.niuben.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index() {
        return "/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password,
                        HttpSession session, RedirectAttributes attributes) {
        User user = userService.findUser(email, password);
        System.out.println(user);
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user",user);
            return "redirect:/index";
        }else {
            attributes.addFlashAttribute("message", "用户账户或密码错误！");
            return "redirect:/";
        }
    }

    @GetMapping("/regist")
    public String regist() {
        return "/regist";
    }

    @PostMapping("/registed")
    public String registed(@RequestParam("email") String email, @RequestParam("password1") String password1,
                           @RequestParam("password2") String password2,RedirectAttributes attributes) {
        if (!password1.equals(password2)) { //判断两次输入密码是否相同
            attributes.addFlashAttribute("message", "两次输入密码不同");
            return "redirect:/regist";
        }
        User user = userService.findUserByEmail(email);
        if (user != null) {  //验证是否已经存在用户名
            attributes.addFlashAttribute("message", "此账户已存在");
            return "redirect:/regist";
        }else {
            User user1 = new User();
            user1.setUsername(email);
            user1.setPassword(password1);
            userService.insertUser(user1);
            return "redirect:/";//注册成功跳转到登录页面
        }
    }
}
