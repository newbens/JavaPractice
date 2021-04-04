package com.niuben.myblog.mapper;

import com.github.pagehelper.Page;
import com.niuben.myblog.domain.Blog;
import com.niuben.myblog.domain.HotType;
import com.niuben.myblog.domain.Tag;
import com.niuben.myblog.domain.Type;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BlogMapper {

    @Select("select count(*) from t_blog")
    Integer findAccount();

    @Select("select * from t_blog")
    List<Blog> getBlogList();

    @Select("select id from t_blog where title=#{title}")
    Long getIdByTitle(String title);

    @Transactional
    @Insert("insert into t_blog(content,title,create_time,typeId,userId,firstPicture,views,update_time,typeName,avatar,flag,description,userName)" +
            " values(#{content},#{title},#{createTime},#{typeId},#{userId},#{firstPicture},#{views},#{updateTime},#{typeName},#{avatar},#{flag},#{description},#{userName})")
    int saveBlog(Blog blog);

    @Select("select * from t_blog where id=#{id}")
    Blog getBlogById(Long id);

    @Transactional
    @Update("update t_blog set title=#{blog.title},content=#{blog.content},flag=#{blog.flag},firstPicture=#{blog.firstPicture}, " +
            "typeName=#{blog.typeName},typeId=#{blog.typeId},avatar=#{blog.avatar},update_time=#{blog.updateTime},description=#{blog.description} where id=#{id}")
    int update(Long id,Blog blog);

    @Transactional
    @Delete("delete from t_blog where id=#{id}")
    void delete(Long id);

    @Select("select id,title,views from t_blog order by views desc limit 0,6")
    List<Blog> getHotBlog();

    @Select("select id,title,views from t_blog order by views desc limit 0,3;")
    List<Blog> getFootHotBlog();

    @Select("select typeName,count(typeId) as num from t_blog left join t_type on t_blog.typeId = t_type.id  group by t_blog.typeName order by num desc limit 0,6;")
    List<HotType> getHotType();

    @Select("select * from t_blog where title like CONCAT('%',#{search},'%') and userId = #{userId}")//使用不到索引
    List<Blog> getSearchByUserId(String search,Long userId);

    @Select("select * from t_blog where title like CONCAT('%',#{search},'%')")//使用不到索引
    List<Blog> getSearch(String search);

    @Select("select * from t_blog where title like CONCAT('%',#{search},'%') and typeId = #{typeId} and userId = #{userId}")//使用不到索引
    List<Blog> getSearchToBlog(String search, String typeId,Long userId);

    @Select("select * from t_blog where typeId=#{typeId} and userId = #{userId}")
    List<Blog> getSearchByTypeIdAndUserId(Long typeId,Long userId);

    @Select("select * from t_blog where typeId=#{typeId}")
    List<Blog> getSearchByTypeId(Long typeId);

    @Select("select b.id,b.name from t_blog_tags as a left join t_tag as b on a.tags_id = b.id where a.blogs_id = #{blogsId};")
    List<Tag> selectBLogTag(Long blogsId);

    @Select("select * from t_blog left join t_blog_tags on t_blog.id=t_blog_tags.blogs_id where tags_id = #{id};")
    List<Blog> getSearchByTagId(Long id);

    @Select("select * from t_blog b where date_format (b.update_time,'%Y') = #{year}")
    List<Blog> getBlogByYear(String year);

    @Select("select date_format(b.update_time,'%Y') as year from t_blog b group by year order by year desc ")
    List<String> getYear();

    @Select("select count(*) from t_blog")
    Long getCount();

    @Transactional
    @Update("update t_blog b set b.views = b.views+1 where id = #{id}")
    void updateView(Long id);

    @Select("select * from t_blog where userId = #{userId}")
    Page<Blog> getBlogByUser(Long userId);

    @Select("select * from t_blog where title like CONCAT('%',#{search},'%') and typeId = #{typeId}")
    List<Blog> getSearchToAllBlog(String search, String typeId);
}
