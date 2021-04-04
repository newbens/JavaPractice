package com.niuben.myblog.service;

import com.github.pagehelper.Page;
import com.niuben.myblog.domain.Type;

import java.util.List;


public interface TypeService {

    int saveType(Type type);

    Type getType(Long id);

    void updateType(Long id, String name);

    void deleteType(Long id);

    Type getTypeByName(String typeName);

    List<Type> allType();


    Integer findCount();

    Page<Type> getPage();



}
