package com.niuben.myblog.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niuben.myblog.domain.Blog;
import com.niuben.myblog.domain.Comment;
import com.niuben.myblog.domain.Type;
import com.niuben.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class Comment_Controller {
    @Autowired
    CommentService commentService;

    @GetMapping("/comments")
    public String list(@RequestParam(required = false,defaultValue = "1") String page, Model model) {
        //设置每页显示评论为8个
        PageHelper.startPage(Integer.parseInt(page), 8);
        PageInfo<Comment> pageInfo = new PageInfo<>(commentService.getPage());
        model.addAttribute("page", pageInfo);
        model.addAttribute("pageNum", page);
        return "admin/comment";
    }

    @PostMapping("/comment/search")
    public String search(@RequestParam(required = false,defaultValue = "1") String page, Model model,String searchcontent) {
        PageHelper.startPage(Integer.parseInt(page), 8);
        PageInfo<Comment> pageInfo = new PageInfo<>(commentService.getSearch(searchcontent));
        model.addAttribute("page", pageInfo);
        model.addAttribute("pageNum", page);
        return "admin/comment";
    }

    @GetMapping("/comment/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        commentService.delete(id);
        return "redirect:/admin/comments";
    }
}
