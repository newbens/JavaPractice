package com.niuben.demo.controller;

import com.niuben.demo.domain.Content;
import com.niuben.demo.service.ShowMailService;
import com.niuben.demo.utils.GetMailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ShowMail {

    @Autowired
    ShowMailService showMailService;

    @GetMapping("/getMail")
    public String getAllMail(Model model) throws Exception {
        List<Content> all = new GetMailUtil().getMail();
        model.addAttribute("mails", all);
        System.out.println("**************************");
        System.out.println(all);
        return "showMail";
    }
}
