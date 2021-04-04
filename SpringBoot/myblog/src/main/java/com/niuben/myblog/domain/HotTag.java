package com.niuben.myblog.domain;

public class HotTag {
    private Long tagsId;
    private Long num;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTagsId() {
        return tagsId;
    }

    public void setTagsId(Long tagsId) {
        this.tagsId = tagsId;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "HotTag{" +
                "tagsId=" + tagsId +
                ", num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}

