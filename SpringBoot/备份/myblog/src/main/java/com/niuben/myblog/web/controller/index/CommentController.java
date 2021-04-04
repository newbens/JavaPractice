package com.niuben.myblog.web.controller.index;

import com.niuben.myblog.domain.Comment;
import com.niuben.myblog.domain.User;
import com.niuben.myblog.service.BlogService;
import com.niuben.myblog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String post(Comment comment, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Long blogid = Long.valueOf(comment.getBlogId());
        if (user != null) {
            //如果是管理员身份评论，设置固定的管理员头像，并标明管理员身份为true
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        }else {
            //如果是游客身份，随机生成头像
            comment.setAvatar(avatar[(int)(Math.random()*4)]);
        }
        comment.setBlog(blogService.getBlog(blogid));
        commentService.saveComment(comment);
        return "redirect:/blog/comments/"+comment.getBlogId();
    }
}
