package com.niuben.myblog.web.controller;


import com.niuben.myblog.domain.User;
import com.niuben.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
//管理员登陆管理器
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    UserService userService;
    @GetMapping
    public String admin() {
        return "admin/login";
    }
    //登录
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        HttpSession session, RedirectAttributes attributes) {
        User user = userService.check(username, password);
        System.out.println(user+"登录了!");
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("admin",user);
            return "admin/index";
        }else {
            attributes.addFlashAttribute("message", "用户名或密码错误！");
            return "redirect:/admin";
        }
    }
    //注销
    @GetMapping("/logout")
    public String logOut(HttpSession session) {
        session.removeAttribute("admin");
        return "redirect:/admin";
    }

}
