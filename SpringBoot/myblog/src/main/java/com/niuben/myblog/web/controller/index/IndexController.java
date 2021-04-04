package com.niuben.myblog.web.controller.index;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niuben.myblog.domain.*;
import com.niuben.myblog.service.BlogService;
import com.niuben.myblog.service.TagService;
import com.niuben.myblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;
    @GetMapping("/")
    public String index(@RequestParam(required = false,defaultValue = "1") String page, Model model) {
        //分页
        PageHelper.orderBy("update_time desc");//降序排序分页
        PageHelper.startPage(Integer.parseInt(page), 5);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogService.getPage());
        model.addAttribute("page", pageInfo);
        model.addAttribute("pageNum", page);
        //获取热度最高的博客
        List<Blog> hotBlog = blogService.getHotBlog();
        model.addAttribute("hotBlog", hotBlog);
        //获取类型热度榜单
        List<HotType> hotType = blogService.getHotType();
        for (HotType type : hotType) {
            type.setId(typeService.getTypeByName(type.getTypeName()).getId());
        }
        model.addAttribute("hotType", hotType);
        //获取标签热度
        List<HotTag> hotTag = tagService.getHotTag();
        for (int i = 0; i <hotTag.size() ; i++) {
            //获取tagId
            Long tagId = hotTag.get(i).getTagsId();
            //通过tagId获取tagName
            String tagName = tagService.getTag(tagId).getName();
            //将tagName分装到hotTag中
            hotTag.get(i).setName(tagName);
        }
        model.addAttribute("hotTag", hotTag);
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam(required = false,defaultValue = "1") String page, Model model,String searchcontent) {
        PageHelper.startPage(Integer.parseInt(page), 5);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogService.getSearch(searchcontent));
        model.addAttribute("page", pageInfo);
        model.addAttribute("pageNum", page);
        return "search";
    }
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable("id") Long id, Model model) {
        List<Tag> tagList = blogService.selectBLogTag(id);
        model.addAttribute("tags", tagList);
        model.addAttribute("blog", blogService.getAndConvert(id));
        return "blog";
    }

}
