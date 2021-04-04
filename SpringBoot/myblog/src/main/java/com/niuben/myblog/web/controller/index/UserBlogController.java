package com.niuben.myblog.web.controller.index;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niuben.myblog.domain.Blog;
import com.niuben.myblog.domain.Tag;
import com.niuben.myblog.domain.Type;
import com.niuben.myblog.domain.User;
import com.niuben.myblog.mapper.BlogTagMapper;
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
import java.util.List;

//博客管理器
@Controller
@RequestMapping("/blog")
public class UserBlogController {


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
    public String list(@RequestParam(required = false,defaultValue = "1") String page,
                       Model model,HttpSession session) {
        User user = (User)session.getAttribute("user");
        PageHelper.startPage(Integer.parseInt(page), 5);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogService.getPageByUser(user.getId()));
        model.addAttribute("page", pageInfo);
        model.addAttribute("pageNum", page);
        List<Type> types = typeService.allType();
        model.addAttribute("types", types);
        return "blogs";
    }

    //新增功能
    @GetMapping("/blogs/inputblog")
    public String input(Model model) {
        List<Type> types = typeService.allType();
        model.addAttribute("types", types);
        List<Tag> tags = tagService.allTag();
        model.addAttribute("tags", tags);
        return "blogs-input";
    }

    @PostMapping("/blogs")
    public String post(Blog blog,RedirectAttributes attributes, HttpSession httpSession) {
        //设置userId
        User user = (User)httpSession.getAttribute("user");
        blog.setUserId(user.getId());
        blog.setUserName(user.getNickName());
        blog.setAvatar(user.getAvatar());
        //设置Tags
        List<Long> tagList = tagService.listTagId(blog.getTagIds());
        blog.setTags(tagList);
        //设置Type名称
        Type type = typeService.getType(blog.getTypeId());
        blog.setTypeName(type.getName());
        //同步更新t_blogs_tags表
        int i = blogService.saveBlog(blog);
        if (i != 1) {
            attributes.addFlashAttribute("message","发布失败");
        }else {
            attributes.addFlashAttribute("message","发布成功");
            //获取blog id
            Long id = blogService.getIdByTitle(blog.getTitle());
            List<Long> tags = blog.getTags();
            for (int x = 0; x < tags.size() ; x++) {
                Long tagId = tags.get(x);
                blogTagMapper.save(id.toString(),tagId.toString());
            }
        }
        return "redirect:/blog/blogs";
    }


    //     删除
    @GetMapping("/blogs/delete/{id}")
    public String deleteBlog(@PathVariable("id")Long id) {
        blogService.deleteBlog(id);
        //删除blog后 删除对应的blog-tag关系
        blogTagMapper.delete(id.toString());
        //删除对应的评论
        commentService.deleteByblogId(id);
        return "redirect:/blog/blogs";

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
        return "edit-blog";
    }


    @PostMapping("/blogs/update/{id}")
    public String updateBlog(@PathVariable String id,Blog blog,RedirectAttributes attributes, HttpSession session) {
        //设置Tags
        blog.setTags(tagService.listTagId(blog.getTagIds()));
        //设置Type名称
        Type type = typeService.getType(blog.getTypeId());
        //设置头像
        User user = (User)session.getAttribute("user");
        blog.setAvatar(user.getAvatar());
        blog.setTypeName(type.getName());
        int i = blogService.updateBlog(Long.parseLong(id), blog);
        if (i != 1) {
            attributes.addFlashAttribute("message","编辑失败");
        }else {
            attributes.addFlashAttribute("message","编辑成功");
            List<Long> tags = blog.getTags();
            blogTagMapper.delete(id);
            for (int x = 0; x < tags.size() ; x++) {
                Long tagId = tags.get(x);
                blogTagMapper.save(id.toString(),tagId.toString());
            }
            }
        return "redirect:/blog/blogs";
    }

    @PostMapping("blogs/search")
    public String searchBlog(@RequestParam(required = false,defaultValue = "1") String page,
                             Model model,String searchcontent,String typeId,
                             HttpSession session) {
        User user = (User)session.getAttribute("user");
        Long userId = user.getId();
        PageHelper.startPage(Integer.parseInt(page), 5);
        PageInfo<Blog> pageInfo = new PageInfo<>();
        if (searchcontent == "" && typeId == "") {
            return "redirect:/blog/blogs";
        }else{
            if (searchcontent == "") {
                pageInfo = new PageInfo<>(blogService.getSearchByTypeIdAndUserId(Long.parseLong(typeId),userId));
            } else if (typeId == "") {
                pageInfo = new PageInfo<>(blogService.getSearchByUserId(searchcontent,userId));
            }else {
                pageInfo = new PageInfo<>(blogService.getSearchToBlog(searchcontent,typeId,userId));
            }
        }
        List<Type> types = typeService.allType();
        model.addAttribute("types", types);
        model.addAttribute("page", pageInfo);
        model.addAttribute("pageNum", page);
        return "blogs";
    }
}


