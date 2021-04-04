package com.niuben.myblog.web.controller.index;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niuben.myblog.domain.Blog;
import com.niuben.myblog.domain.Type;
import com.niuben.myblog.service.BlogService;
import com.niuben.myblog.service.TagService;
import com.niuben.myblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TypeAdminController {

    @Autowired
    TypeService typeService;
    @Autowired
    BlogService blogService;


    @GetMapping("/types/{id}")
    public String typeBlog(@RequestParam(required = false,defaultValue = "1") String page,@PathVariable("id") Long id,Model model) {
        PageHelper.startPage(Integer.parseInt(page), 5);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogService.getSearchByTypeId(id));
        //获取所有Type
        List<Type> types = typeService.allType();
        model.addAttribute("types", types);
        model.addAttribute("page", pageInfo);
        model.addAttribute("pageNum", page);
        model.addAttribute("id",id);
        return "types";
    }
}
