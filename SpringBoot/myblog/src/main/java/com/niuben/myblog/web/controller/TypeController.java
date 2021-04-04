package com.niuben.myblog.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niuben.myblog.domain.Type;
import com.niuben.myblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
//类型管理器
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    TypeService typeService;
    //-----------分页功能----------------
    @GetMapping("/types")
    public String list( @RequestParam(required = false,defaultValue = "1") String page, Model model) {
        PageHelper.startPage(Integer.parseInt(page), 5);
        PageInfo<Type> pageInfo = new PageInfo<>(typeService.getPage());
        model.addAttribute("page", pageInfo);
        model.addAttribute("pageNum", page);
        return "admin/types";
    }

    //新增功能
    @GetMapping("/types/inputtype")
    public String input() {
        return "/admin/types-input";
    }

    //保存功能
    @PostMapping("/types")
    public String saveType(Type type,RedirectAttributes attributes) {
        String name = type.getName();
        Type typeByName = typeService.getTypeByName(name);
        if (typeByName == null ) {
            int i = typeService.saveType(type);
                attributes.addFlashAttribute("message","添加成功");
        }else {
            attributes.addFlashAttribute("message","此名称已存在");
        }
        return "redirect:/admin/types";
    }

    //编辑
    @GetMapping("/types/input/{id}")
    public String editInput(@PathVariable("id") Long id,Model model) {
        Type type = typeService.getType(id);
        model.addAttribute("edit", type);
        return "admin/edit-type";
    }

    //更新
    @PostMapping("/types/update")
    public String updateType(Type type,RedirectAttributes attributes) {
        String name = type.getName();
        Type typeByName = typeService.getTypeByName(name);
        if (typeByName == null ) {
            //System.out.println(type);
            typeService.updateType(type.getId(),type.getName());
            attributes.addFlashAttribute("message","修改成功");
        }else {
            attributes.addFlashAttribute("message","修改的ID或名称已存在");
        }
        return "redirect:/admin/types";
    }
    //     删除s
    @GetMapping("/types/delete/{id}")
    public String deleteType(@PathVariable("id")Long id) {
        typeService.deleteType(id);
        return "redirect:/admin/types";
    }
}
