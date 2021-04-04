package com.niuben.myblog.web.controller.index;

import com.niuben.myblog.domain.User;
import com.niuben.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/person")
public class PersonalCenterController {

    @Autowired
    UserService userService;

    @GetMapping("/info")
    public String info() {
        return "personal";
    }

    @GetMapping("/chgpw")
    public String changePassword() {
        return "chgpw";
    }

    @PostMapping("/changed")
    public String changedPwd(@RequestParam("username") String username,
                             @RequestParam("oldpassword") String oldpassword,
                             @RequestParam("newpassword") String newpassword,
                             RedirectAttributes attributes) {
        String passwordByUsername = userService.getPasswordByUsername(username);
        //判断原密码是否正确
        if (!passwordByUsername.equals(oldpassword)) {
            attributes.addFlashAttribute("message", "原密码输入错误！");
            return "redirect:/person/chgpw";
        } else {
            boolean updatePassword = userService.updatePassword(username, newpassword);
            //判断是否修改成功
            if (updatePassword) {
                return "redirect:/";
            }
            attributes.addFlashAttribute("message", "修改失败");
            return "redirect:/chgpw";
        }
    }
    //获取收藏列表
    @GetMapping("/collect")
    public String getCollect() {
        return "collects";
    }
}
