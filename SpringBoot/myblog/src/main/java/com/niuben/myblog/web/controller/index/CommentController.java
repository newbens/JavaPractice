package com.niuben.myblog.web.controller.index;

import com.niuben.myblog.domain.Blog;
import com.niuben.myblog.domain.Comment;
import com.niuben.myblog.domain.User;
import com.niuben.myblog.service.BlogService;
import com.niuben.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class CommentController {

    @Autowired
    CommentService commentService;
    @Autowired
    BlogService blogService;
    //评论头像
    private String[] avatar = {"/images/kkx.png","/images/mr.png","/images/sm.png","/images/zz.png"};

    @GetMapping("/comments/{id}")
    public String comment(@PathVariable Long id,Model model) {
        //得到页面的评论
        List<Comment> comments = commentService.litsCommentByBlogId(id);
        model.addAttribute("comments", comments);
        return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session, RedirectAttributes attributes) {
        User user = (User) session.getAttribute("user");
//        判断是否登录，如果没登录跳转登录
        if (user == null) {
            attributes.addFlashAttribute("message", "尚未登陆，登陆后才可以评论! ");
            return "userLogin";
        }
        comment.setEmail(user.getEmail());
        comment.setNickname(user.getNickName());
        Long blogid = Long.valueOf(comment.getBlogId());
        Blog blog = blogService.getBlog(blogid);
        if (user.getId() != blog.getUserId()) { //不是博主
            comment.setAdminComment(false);
        }else comment.setAdminComment(true);
        comment.setAvatar(user.getAvatar());
        comment.setBlog(blogService.getBlog(blogid));
        commentService.saveComment(comment);
        return "redirect:/blog/comments/"+comment.getBlogId();
    }
}
