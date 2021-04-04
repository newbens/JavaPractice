package com.niuben.controller;

import com.niuben.domain.Account;
import com.niuben.domain.User;
import javafx.scene.input.DataFormat;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.Context;
import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/param")
@SessionAttributes(value = {"A"})
public class ParamController {

    @RequestMapping("saveAccount")
    public String testparam(Account account) {
        System.out.println(account);
        return "success";
    }

    @RequestMapping("saveUser")
    public String saveUser(User user) {
        System.out.println(user);
        return "success";
    }

    /**
     * 获取原生API
     * @return
     */
    @RequestMapping("testServlet")
    public String testServlet(HttpServletRequest request) {
        String a = request.getParameter("a");
        System.out.println("a ="+a);
        return "success";
    }

    @RequestMapping("testRequestParam")
    public String testRequestParam(@RequestParam("surname") String name) {
        System.out.println(name);
        return "success";
    }
    @RequestMapping("testRequestBody")
    public String testRequestBody(@RequestBody String body) throws UnsupportedEncodingException {
        URLDecoder.decode(body, "GBK");
        System.out.println(body);
        return "success";
    }
    @RequestMapping("testPathVariable/{id}")
    public String testPathVariable(@PathVariable(name = "id")String id ) {
        System.out.println(id);
        return "success";
    }
    @RequestMapping("testModelAttribute")
    public String testModelAttribute() {
        System.out.println("testModelAttribute");
        return "success";
    }
    @ModelAttribute
    public void show(String uname) {
        System.out.println("ModelAttribute执行了");
    }
    @RequestMapping("setsessionAtttributes")
    public String testsessionAtttributes(Model model) {
        System.out.println("setsessionAtttributes执行了");
        model.addAttribute("A", "a");
        return "success";
    }

    @RequestMapping("getsessionAtttributes")
    public String getsessionAtttributes(ModelMap modelMap) {
        System.out.println("getsessionAtttributes执行了");
        Object a = modelMap.getAttribute("A");
        System.out.println(a);
        return "success";
    }

    @RequestMapping("delsessionAtttributes")
    public String delsessionAtttributes(SessionStatus status) {
        System.out.println("delsessionAtttributes执行了");
        status.setComplete();  //删除session
        return "success";
    }
}
