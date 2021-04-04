package com.niuben.myblog.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niuben.myblog.domain.Type;
import com.niuben.myblog.mapper.TypeMapper;
import com.niuben.myblog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImp implements TypeService {

    @Autowired
    TypeMapper typeMapper;

    @Override
    public int saveType(Type type) {
        int i = typeMapper.saveType(type);
        return i;
    }

    @Override
    public Type getType(Long id) {
       return typeMapper.getTypeById(id);
    }

    @Override
    public void updateType(Long id, String name) {
        typeMapper.update(id,name);
    }


    @Override
    public void deleteType(Long id) {
        typeMapper.delete(id);
    }

    @Override
    public Type getTypeByName(String typeName) {
        return typeMapper.getTypeByName(typeName);
    }

    @Override
    public List<Type> allType() {
        return typeMapper.getTypeList();
    }

    @Override
    public Integer findCount() {
        return typeMapper.findAccount();
    }

    @Override
    public Page<Type> getPage() {
        return (Page<Type>)typeMapper.getTypeList();
    }
}
