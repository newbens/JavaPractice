package com.niuben.myblog.service.imp;

import com.github.pagehelper.Page;
import com.niuben.myblog.domain.Blog;
import com.niuben.myblog.domain.Blog;
import com.niuben.myblog.domain.HotType;
import com.niuben.myblog.domain.Tag;
import com.niuben.myblog.exception.NotFoundException;
import com.niuben.myblog.mapper.BlogMapper;
import com.niuben.myblog.mapper.BlogTagMapper;
import com.niuben.myblog.mapper.TagMapper;
import com.niuben.myblog.service.BlogService;
import com.niuben.myblog.utils.MarkdownUtils;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class BlogServiceImp implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Autowired
    BlogTagMapper blogTagMapper;

    @Autowired
    TagMapper tagMapper;

    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());//初始化时间
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        int i = blogMapper.saveBlog(blog);
        return i;
    }

    //将输入框代码转换成HTML格式
    @Override
    public Blog getAndConvert(Long id) {
        Blog blog = blogMapper.getBlogById(id);
        if (blog == null) {
            throw new NotFoundException("博客不存在");
        }
        String content = blog.getContent();
        String markdownToHtmlExtensions = MarkdownUtils.markdown2Html(content);
        blog.setContent(markdownToHtmlExtensions);
        blogMapper.updateView(id);
        return blog;
    }

    @Override
    public Blog getBlog(Long id) {
        return blogMapper.getBlogById(id);
    }

    @Override
    public int updateBlog(Long id, Blog blog) {
        blog.setUpdateTime(new Date());
        return blogMapper.update(id,blog);
    }


    @Override
    public void deleteBlog(Long id) {
        blogMapper.delete(id);
    }

    @Override
    public Blog getBlogByName(String BlogName) {
        return null;
    }


    @Override
    public List<Blog> allBlog() {
        return blogMapper.getBlogList();
    }

    @Override
    public Integer findCount() {
        return blogMapper.findAccount();
    }

    @Override
    public Page<Blog> getPage() {
        List<Blog> blogList = blogMapper.getBlogList();
        //查询每个blog的标签,并为每个blog设置tag name属性。
        for (Blog blog : blogList) {
            List<String> tagNames = new ArrayList<>();
            List<Long> tagsByBLog = blogTagMapper.getTagsByBLog(blog.getId());
            for (Long tagIds : tagsByBLog) {
                String name = tagMapper.getNameById(tagIds);
                tagNames.add(name);
            }
            blog.setTagNames(tagNames);
        }
        return (Page<Blog>)blogList;
    }

    @Override
    public Long getIdByTitle(String title) {
        return blogMapper.getIdByTitle(title);
    }


    @Override
    public Page<Blog> getPageByUser(Long userId) {
        return blogMapper.getBlogByUser(userId);
    }

    //获取热度高的博客前六名
    @Override
    public List<Blog> getHotBlog() {
        return blogMapper.getHotBlog();
    }

    @Override
    public List<HotType> getHotType() {
        return blogMapper.getHotType();
    }

    @Override
    public List<Blog> getSearch(String search) {
        return blogMapper.getSearch(search);
    }

    @Override
    public List<Blog> getSearchToBlog(String search, String typeId) {
        return null;
    }

    @Override
    public List<Blog> getSearchByUserId(String search, Long userId) {
        return blogMapper.getSearchByUserId(search,userId);
    }

    @Override
    public List<Blog> getSearchToBlog(String search, String typeId,Long userId) {
        return blogMapper.getSearchToBlog(search,typeId,userId);
    }

    @Override
    public List<Blog> getSearchToAllBlog(String search, String typeId) {
        return blogMapper.getSearchToAllBlog(search, typeId);
    }

    @Override
    public List<Blog> getSearchByTypeIdAndUserId(Long typeId,Long userId) {
        return blogMapper.getSearchByTypeIdAndUserId(typeId,userId);
    }

    @Override
    public List<Blog> getSearchByTypeId(Long typeId) {
        return blogMapper.getSearchByTypeId(typeId);
    }

    @Override
    public List<Tag> selectBLogTag(Long id) {
        List<Tag> tagList = blogMapper.selectBLogTag(id);
        return tagList;
    }

    @Override
    public List<Blog> getSearchByTagId(Long id) {
        return blogMapper.getSearchByTagId(id);
    }
    //按照年份获取博客
    @Override
    public Map<String, List<Blog>> getBlogByYear() {
        Map<String, List<Blog>> map = new LinkedHashMap<>();
        //先获取所有年份
        List<String> years = blogMapper.getYear();
        //遍历年份，获取每个年份所有的博客
        for (String year : years) {
            map.put(year,blogMapper.getBlogByYear(year));
        }
        return map;
    }

    @Override
    public Long getCount() {
        return blogMapper.getCount();
    }



}
