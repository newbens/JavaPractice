package com.niuben.myblog.web.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niuben.myblog.domain.Blog;
import com.niuben.myblog.domain.Tag;
import com.niuben.myblog.domain.Type;
import com.niuben.myblog.domain.User;
import com.niuben.myblog.mapper.BlogTagMapper;
import com.niuben.myblog.mapper.CommentMapper;
import com.niuben.myblog.service.BlogService;
import com.niuben.myblog.service.CommentService;
import com.niuben.myblog.service.TagService;
import com.niuben.myblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

//博客管理器
@Controller
@RequestMapping("/admin")
public class BlogController {


    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;
    @Autowired
    BlogTagMapper blogTagMapper;
    @Autowired
    CommentService commentService;


    //-----------分页功能----------------
    @GetMapping("/blogs")
    public String list(@RequestParam(required = false,defaultValue = "1") String page, Model model) {
        PageHelper.startPage(Integer.parseInt(page), 5);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogService.getPage());
        model.addAttribute("page", pageInfo);
        model.addAttribute("pageNum", page);
        List<Type> types = typeService.allType();
        model.addAttribute("types", types);
        return "admin/blogs";
    }

    //新增功能
    @GetMapping("/blogs/inputblog")
    public String input(Model model) {
        List<Type> types = typeService.allType();
        model.addAttribute("types", types);
        List<Tag> tags = tagService.allTag();
        model.addAttribute("tags", tags);
        return "admin/blogs-input";
    }

    @PostMapping("/blogs")
    public String post(Blog blog,RedirectAttributes attributes, HttpSession httpSession) {
        //设置userId
        User user = (User) httpSession.getAttribute("user");
        blog.setUserId(user.getId());
        blog.setUserName(user.getNickName());
        //设置TypeId
        Long typeId = Long.parseLong(blog.getTypeIds());
        blog.setTypeId(typeId);
        //设置Tags
        List<Tag> tagList = tagService.listTag(blog.getTagIds());
        blog.setTags(tagList);
        //设置Type名称
        Type type = typeService.getType(typeId);
        blog.setTypeName(type.getName());
        //同步更新t_blogs_tags表
        int i = blogService.saveBlog(blog);
        if (i != 1) {
            attributes.addFlashAttribute("message","发布失败");
        }else {
            attributes.addFlashAttribute("message","发布成功");
            Long blogId = blog.getTypeId();
            List<Tag> tags = blog.getTags();
            for (int x = 0; x < tags.size() ; x++) {
                Long tagId = tags.get(x).getId();
                blogTagMapper.save(blogId.toString(),tagId.toString());
            }
        }
        return "redirect:/admin/blogs";
    }


    //     删除
    @GetMapping("/blogs/delete/{id}")
    public String deleteBlog(@PathVariable("id")Long id) {
        blogService.deleteBlog(id);
        //删除blog后 删除对应的blog-tag关系
        blogTagMapper.delete(id.toString());
        //删除对应的评论
        commentService.deleteByblogId(id);
        return "redirect:/admin/blogs";

    }

    //编辑功能
    @GetMapping("/blogs/edit/{id}")
    public String editBlog(@PathVariable("id") Long id,Model model) {
        List<Type> types = typeService.allType();
        model.addAttribute("types", types);
        List<Tag> tags = tagService.allTag();
        model.addAttribute("tags", tags);
        Blog blog = blogService.getBlog(id);
        model.addAttribute("blog", blog);
        return "admin/edit-blog";
    }


    @PostMapping("/blogs/update/{id}")
    public String updateBlog(@PathVariable String id,Blog blog,RedirectAttributes attributes, HttpSession httpSession) {
        //设置TypeId
        Long typeId = Long.parseLong(blog.getTypeIds());
        blog.setTypeId(typeId);
        //设置Tags
        blog.setTags(tagService.listTag(blog.getTagIds()));
        //设置Type名称
        Type type = typeService.getType(typeId);
        blog.setTypeName(type.getName());
        int i = blogService.updateBlog(Long.parseLong(id), blog);
        if (i != 1) {
            attributes.addFlashAttribute("message","编辑失败");
        }else {
            attributes.addFlashAttribute("message","编辑成功");
            List<Tag> tags = blog.getTags();
            blogTagMapper.delete(id);
            for (int x = 0; x < tags.size() ; x++) {
                Long tagId = tags.get(x).getId();
                blogTagMapper.save(id.toString(),tagId.toString());
            }
            }
        return "redirect:/admin/blogs";
    }

    @PostMapping("blogs/search")
    public String searchBlog(@RequestParam(required = false,defaultValue = "1") String page, Model model,String searchcontent,String typeId) {
        PageHelper.startPage(Integer.parseInt(page), 5);
        PageInfo<Blog> pageInfo = new PageInfo<>();
        if (searchcontent == "" && typeId == "") {
            return "redirect:/admin/blogs";
        }else{
            if (searchcontent == "") {
                pageInfo = new PageInfo<>(blogService.getSearchByTypeId(Long.parseLong(typeId)));
            } else if (typeId == "") {
                pageInfo = new PageInfo<>(blogService.getSearch(searchcontent));
            }else {
                pageInfo = new PageInfo<>(blogService.getSearchToBlog(searchcontent,typeId));
            }
        }
        List<Type> types = typeService.allType();
        model.addAttribute("types", types);
        model.addAttribute("page", pageInfo);
        model.addAttribute("pageNum", page);
        return "admin/blogs";
    }
}


