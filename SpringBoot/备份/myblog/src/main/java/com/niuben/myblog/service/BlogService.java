package com.niuben.myblog.service;

import com.github.pagehelper.Page;
import com.niuben.myblog.domain.Blog;
import com.niuben.myblog.domain.HotType;
import com.niuben.myblog.domain.Tag;

import java.util.List;
import java.util.Map;

public interface BlogService {

    int saveBlog(Blog Blog);

    Blog getAndConvert(Long id);

    Blog getBlog(Long id);

    int updateBlog(Long id,Blog blog);

    void deleteBlog(Long id);

    Blog getBlogByName(String BlogName);

    List<Blog> allBlog();

    Integer findCount();

    Page<Blog> getPage();

    List<Blog> getHotBlog();

    List<HotType> getHotType();

    List<Blog> getSearch(String search);

    List<Blog> getSearchToBlog(String search,String typeId);

    List<Blog> getSearchByTypeId(Long typeId);

    List<Tag> selectBLogTag(Long id);

    List<Blog> getSearchByTagId(Long id);

    Map<String,List<Blog>> getBlogByYear();

    Long getCount();

    List<Blog> getFootHotBLog();
}
