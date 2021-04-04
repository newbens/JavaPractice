package com.niuben.myblog.mapper;

import com.niuben.myblog.domain.HotTag;
import com.niuben.myblog.domain.Tag;
import com.niuben.myblog.domain.Type;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TagMapper {
    //查询总标签数
    @Select("select count(*) from t_tag")
    Integer findAccount();
    //查询所有标签
    @Select("select * from t_tag")
    List<Tag> getTagList();

    @Select("select * from t_tag where name=#{name}")
    Tag getTagByName(String name);

    @Transactional
    @Insert("insert into t_tag(name) values(#{name})")
    int saveTag(Tag tag);

    @Select("select * from t_tag where id=#{id}")
    Tag getTagById(Long id);

    @Transactional
    @Update("update t_tag set name=#{name} where id=#{id}")
    void update(Long id,String name);

    @Transactional
    @Delete("delete from t_tag where id=#{id}")
    void delete(Long id);

    @Select("select tags_id,count(id)as num from t_blog_tags group by tags_id order by num desc limit 0,8;")
    List<HotTag> getHotTag();

    @Select("select name from t_tag where id=#{tagId}")
    String getNameById(Long tagId);
}
