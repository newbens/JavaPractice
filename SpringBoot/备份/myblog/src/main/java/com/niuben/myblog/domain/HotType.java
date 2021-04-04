package com.niuben.myblog.domain;

public class HotType {
    private Long id;
    private String typeName;
    private Long num;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }


    @Override
    public String toString() {
        return "HotType{" +
//                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", num=" + num +
                '}';
    }
}

