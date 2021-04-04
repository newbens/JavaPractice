package com.niuben.myblog.service;

import com.github.pagehelper.Page;
import com.niuben.myblog.domain.HotTag;
import com.niuben.myblog.domain.Tag;
import com.niuben.myblog.domain.Type;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TagService {
    int saveTag(Tag tag);

    Tag getTag(Long id);

    void updateTag(Long id, String name);

    void deleteTag(Long id);

    Tag getTagByName(String tagName);

    List<Tag> allTag();


    List<Long> listTagId(String ids);

    Integer findCount();

    Page<Tag> getPage();

    List<HotTag> getHotTag();
}
