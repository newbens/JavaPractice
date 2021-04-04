package com.niuben.myblog.web.controller.index;

import com.niuben.myblog.domain.Blog;
import com.niuben.myblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
//归档 按年份分类
@Controller
public class archivesController {

    @Autowired
    BlogService blogService;

    @GetMapping("/archives")
    public String archives(Model model) {
        //得到的map存放年份对应的Blog
       Map<String, List<Blog>> map = blogService.getBlogByYear();
        model.addAttribute("map", map);
        Long count = blogService.getCount();
        model.addAttribute("count", count);
        return "archives";
    }
}
