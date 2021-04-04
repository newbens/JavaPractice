package com.niuben.myblog.mapper;

import com.niuben.myblog.domain.Tag;
import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface BlogTagMapper {

    @Insert("insert into t_blog_tags(blogs_id,tags_id) values(#{blogId},#{tagId})")
    void save(String blogId,String tagId);

    @Transactional
    @Delete("delete from t_blog_tags where blogs_id=#{blogId} ")
    void delete(String blogId);

    @Select("select * from t_blog_tags")
    void selectALL();

    @Select("select * from t_blog_tags where blogs_id=#{blogId} and tags_id=#{tagId}")
    void select(String blogId,String tagId);

    @Select("select tags_id from t_blog_tags where blogs_id=#{blogId}")
    List<Long> getTagsByBLog(Long blogId);

}
