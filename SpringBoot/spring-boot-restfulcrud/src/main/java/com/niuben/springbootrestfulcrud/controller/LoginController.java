package com.niuben.springbootrestfulcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/user/login")
    //@RequestMapping(value = "/login",method = RequestMethod.POST)  和上面的效果一样
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session) {
        System.out.println(username+"   "+password);
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("loginUser",username);
            return "redirect:/main.html"    ;
        }else{
            map.put("error", "密码或账户名错误");
            return "login";
        }
    }



}
