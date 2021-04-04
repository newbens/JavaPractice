package com.niuben.myblog.service;

import com.github.pagehelper.Page;
import com.niuben.myblog.domain.Comment;

import java.util.List;

public interface CommentService {


    //获取评论列表
    List<Comment> litsCommentByBlogId(Long blogId);

    //保存评论
    Integer  saveComment(Comment comment);

    Page<Comment> getPage();

    List<Comment> getSearch(String searchcontent);

    void delete(Long id);

    void deleteByblogId(Long id);
}
