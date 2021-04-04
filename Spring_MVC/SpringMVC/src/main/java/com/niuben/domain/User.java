package com.niuben.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.crypto.Data;

public class User {

    private String uname ;
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Data date;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Data getDate() {
        return date;
    }

    public void setDate(Data date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", age='" + age + '\'' +
                ", date=" + date +
                '}';
    }
}
