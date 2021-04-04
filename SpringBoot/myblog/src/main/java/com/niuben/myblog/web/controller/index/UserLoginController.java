package com.niuben.myblog.web.controller.index;


import com.niuben.myblog.domain.User;
import com.niuben.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

//用户登陆管理器
@Controller
@RequestMapping("/user")
public class UserLoginController {

    @Autowired
    UserService userService;

    @GetMapping
    public String admin() {
        return "userLogin";
    }

    //登录
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
                        HttpSession session, RedirectAttributes attributes) {
        User user = userService.check(username, password);
        System.out.println(user + "登录了!");
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user", user);
            return "redirect:/";
        } else {
            attributes.addFlashAttribute("message", "用户名或密码错误！");
            return "redirect:/user";
        }
    }

    //注销
    @GetMapping("/logout")
    public String logOut(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/user";
    }

    //注册
    @GetMapping("/register")
    public String register() {
        return "registered";
    }
    @PostMapping("/registered")
    public String registered(User user,HttpSession session, RedirectAttributes attributes) {
        User user1 = userService.insert(user);
        session.setAttribute("user", user);
        return "redirect:/";
    }
}
