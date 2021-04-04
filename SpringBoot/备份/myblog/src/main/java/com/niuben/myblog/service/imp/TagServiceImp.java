package com.niuben.myblog.service.imp;

import com.github.pagehelper.Page;
import com.niuben.myblog.domain.HotTag;
import com.niuben.myblog.domain.Tag;
import com.niuben.myblog.domain.Type;
import com.niuben.myblog.mapper.TagMapper;
import com.niuben.myblog.mapper.TypeMapper;
import com.niuben.myblog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImp implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public int saveTag(Tag tag) {
        int i = tagMapper.saveTag(tag);
        return i;
    }

    @Override
    public Tag getTag(Long id) {
        return tagMapper.getTagById(id);
    }

    @Override
    public void updateTag(Long id, String name) {
        tagMapper.update(id,name);
    }


    @Override
    public void deleteTag(Long id) {
        tagMapper.delete(id);
    }

    @Override
    public Tag getTagByName(String tagName) {
        return tagMapper.getTagByName(tagName);
    }

    @Override
    public List<Tag> allTag() {
        return tagMapper.getTagList();
    }

    @Override
    public List<Tag> listTag(String ids) {
        List<Long> list = covertToList(ids);
        List<Tag> tagList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Tag tagById = tagMapper.getTagById(list.get(i));
            tagList.add(tagById);
        }
        return tagList;
    }

    private List covertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if (ids != null) {
            String[] idarray = ids.split(",");
            for (int i = 0; i < idarray.length; i++) {
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }

    @Override
    public Integer findCount() {
        return tagMapper.findAccount();
    }

    @Override
    public Page<Tag> getPage() {
        return (Page<Tag>) tagMapper.getTagList();
    }

    @Override
    public List<HotTag> getHotTag() {
        return tagMapper.getHotTag();
    }

}