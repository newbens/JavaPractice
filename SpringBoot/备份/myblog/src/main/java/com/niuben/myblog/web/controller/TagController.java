package com.niuben.myblog.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niuben.myblog.domain.Tag;
import com.niuben.myblog.service.TagService;
import com.niuben.myblog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    TagService tagService;

    //-----------分页功能----------------
    @GetMapping("/tags")
    public String list(@RequestParam(required = false,defaultValue = "1") String page, Model model) {
        PageHelper.startPage(Integer.parseInt(page), 5);
        PageInfo<Tag> pageInfo = new PageInfo<>(tagService.getPage());
        model.addAttribute("page", pageInfo);
        model.addAttribute("pageNum", page);
//        System.out.println(pageInfo);
        return "admin/tags";
    }

    //新增功能
    @GetMapping("/tags/inputtag")
    public String input() {
        return "/admin/tags-input";
    }
    @PostMapping("/tags")
    public String saveTag(Tag type,RedirectAttributes attributes) {
        String name = type.getName();
        Tag typeByName = tagService.getTagByName(name);
        if (typeByName == null ) {
            int i = tagService.saveTag(type);
            attributes.addFlashAttribute("message","添加成功");
        }else {
            attributes.addFlashAttribute("message","此名称已存在");
        }
        return "redirect:/admin/tags";
    }

    //编辑
    @GetMapping("/tags/input/{id}")
    public String editInput(@PathVariable("id") Long id, Model model) {
        Tag tag = tagService.getTag(id);
        model.addAttribute("edit", tag);
        return "admin/edit-tag";
    }

    //更新
    @PostMapping("/tags/update")
    public String updateTag(Tag type, RedirectAttributes attributes) {
        String name = type.getName();
        Tag typeByName = tagService.getTagByName(name);
        if (typeByName == null ) {
            System.out.println(type);
            tagService.updateTag(type.getId(),type.getName());
            attributes.addFlashAttribute("message","修改成功");
        }else {
            attributes.addFlashAttribute("message","修改的ID或名称已存在");
        }
        return "redirect:/admin/tags";
    }

    //删除s
    @GetMapping("/tags/delete/{id}")
    public String deleteTag(@PathVariable("id")Long id) {
        tagService.deleteTag(id);
        return "redirect:/admin/tags";
    }
}
