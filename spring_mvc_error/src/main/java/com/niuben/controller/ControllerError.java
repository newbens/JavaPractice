package com.niuben.controller;

import com.niuben.controller.Exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("error")
public class ControllerError {

    @RequestMapping("test1")
    public String Test1() throws SysException {
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("计算错误！！！");
        }
        System.out.println("test1");
        return "success";
    }
}
