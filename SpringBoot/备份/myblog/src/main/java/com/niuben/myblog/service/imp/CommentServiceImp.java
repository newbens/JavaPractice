package com.niuben.myblog.service.imp;

import com.github.pagehelper.Page;
import com.niuben.myblog.domain.Comment;
import com.niuben.myblog.mapper.CommentMapper;
import com.niuben.myblog.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/*
  本模块主要功能：
    实现评论的层级关系查找，思想如下：
        首先评论表中有两个重要的字段：1.父级评论ID，2.博客ID
        首先我们通过前端的url路径获得b博客ID,然后通过博客ID查询到，所有是这个博客下的评论，
        遍历所有评论找到所有父级评论为-1的评论，说明这些评论都是顶级评论，其他评论都是回复的，
        其他的评论属于第二级。然后我们遍历这些父级评论，通过父级评论id，查找到这个父级评论的所有子
        评论，然后递归执行，查找到所有回复，递归结束时，这个父级评论的所有子评论，已经全部得到。
 */


@Service
public class CommentServiceImp implements CommentService {

    @Autowired
    CommentMapper commentMapper;
    //
    @Override
    public List<Comment> litsCommentByBlogId(Long blogId) {
        List<Comment> commentListByBlogId = commentMapper.getCommentListByBlogId(blogId);//获得所有父级id
        List<Comment> comments = eachComment(commentListByBlogId);
        return comments;
    }

    @Transactional
    @Override
    public Integer saveComment(Comment comment) {
        Long parentCommentId = Long.parseLong(comment.getParentCommentId());
        //如果父级id不为-1说明是一条回复
        if (parentCommentId != -1) {
            //找到父级评论并set
            comment.setParentComment(commentMapper.getCommentById(parentCommentId));
        }else {
            comment.setParentComment(null);
        }
        comment.setCreateTime(new Date());
        return commentMapper.saveComment(comment);
    }

    @Override
    public Page<Comment> getPage() {
        return commentMapper.getAll();
    }

    @Override
    public List<Comment> getSearch(String searchcontent) {
        return commentMapper.getSearch(searchcontent);

    }

    @Override
    public void delete(Long id) {
        commentMapper.delete(id);
    }

    @Override
    public void deleteByblogId(Long id) {
        commentMapper.deleteByBlogId(id);
    }

    /**
     * 循环每个顶级的评论节点
     * @param comments
     * @return
     */
    public List<Comment> eachComment(List<Comment> comments) {
        List<Comment> commentsView = new ArrayList<>();//将每个顶级节点copy到新的集合
        for (Comment comment : comments) {
            Comment c = new Comment();
            BeanUtils.copyProperties(comment,c);
            commentsView.add(c);
        }
        //合并子评论到父评论的集合中
        combineChildren(commentsView);
        return commentsView;
    }

    /**
     * 合并子评论到父评论中
     * @param comments //所有父评论的集合
     */
    public void combineChildren(List<Comment> comments) {
        for (Comment comment : comments) {
            //找到每条评论的子回复
            List<Comment> replyComments = commentMapper.getCommentListByParentId(Long.valueOf(comment.getId()));
            for (Comment replyComment : replyComments) {
                //给每个回复的评论set自己的父评论
                replyComment.setParentComment(commentMapper.getCommentById(Long.valueOf(replyComment.getParentCommentId())));
                recursively(replyComment);
            }
            //将最终得到的所有子评论 集合设置到父评论属性中
            comment.setReplyComments(tempReplys);
            //清空存放子评论的容器
            tempReplys = new ArrayList<>();
        }

    }
    //存放所有子代的集合
    private List<Comment> tempReplys = new ArrayList<>();
    /**
     *迭代递归找出所有子集
     * @param comment
     */
    public void recursively(Comment comment) {
        if (!tempReplys.contains(comment)) {
            tempReplys.add(comment);
        }
        //得到自己的所有子节点
        List<Comment> commentListByParentId = commentMapper.getCommentListByParentId(comment.getId());
        if (commentListByParentId.size() > 0) {
            for (Comment comment1 : commentListByParentId) {
                //set自己的父评论
                comment1.setParentComment(comment);
                    tempReplys.add(comment1);
                recursively(comment1);
            }
        }
    }
}

