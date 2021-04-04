package com.niuben.myblog.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;

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


}
