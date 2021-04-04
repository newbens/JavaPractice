package com.niuben.myblog.mapper;

import com.github.pagehelper.Page;
import com.niuben.myblog.domain.Blog;
import com.niuben.myblog.domain.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface CommentMapper {
    //获取所有父级评论并通过发表时间升序
    @Select("select * from t_comment where blog_id = #{blogId} and parent_comment_id = -1  order by createTime desc")
    List<Comment> getCommentListByBlogId(Long blogId);
    //保存评论
    @Insert("insert into t_comment(content,createTime,email,nickName,blog_id,parent_comment_id,avatar,admin_comment)" +
            " values(#{content},#{createTime},#{email}," +
            "#{nickname},#{blogId},#{parentCommentId},#{avatar},#{adminComment})")
    Integer saveComment(Comment comment);

    @Select("select * from t_comment where id=#{id}")
    Comment getCommentById(Long Id);

    @Select("select * from t_comment where parent_comment_id = #{id}")
    List<Comment> getCommentListByParentId(Long id);

    @Select("select * from t_comment")
    Page<Comment> getAll();

    @Select("select * from t_comment where content like CONCAT('%',#{searchcontent},'%')")
    List<Comment> getSearch(String searchcontent);

    @Delete("delete from t_comment where id=#{id}")
    void delete(Long id);

    @Delete("delete from t_comment where blog_id=#{id}")
    void deleteByBlogId(Long id);
}
