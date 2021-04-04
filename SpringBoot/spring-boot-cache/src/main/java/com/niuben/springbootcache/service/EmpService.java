package com.niuben.springbootcache.service;

import com.niuben.springbootcache.bean.Employee;
import com.niuben.springbootcache.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resources;
import java.security.Key;



//@CacheConfig  抽取缓存的公共配置，简化编程
@Service
public class EmpService {

    @Autowired
    EmpMapper empMapper;

    /**
     * @param id
     * @return 运行流程：
     * 1.先去查询cache组件，按照传入的chchename获取，如果没有cache组件会自动创建
     * 2.去cache中查找缓存，使用一个key，默认是方法参数；
     * key是按照某种策略生成的
     * SimpleKeyGenerator生成的key的策略
     * 如果没有参数,key = new SimpleKey()
     * 如果有一个参数： key = 参数的值
     * 如果有多个参数； key = new SimpleKey()
     * 3.没有查到缓存就调用目标方法
     * 4将目标方法返回的结果放进缓存中。
     */
    @Cacheable(cacheNames = {"emp"}, key = "#id")//将方法的运行结果加入到缓存
    public Employee getEmp(@PathVariable("id") Integer id) {
        System.out.println("查询" + id + "员工！");
        return empMapper.findById(id);
    }

    /**
     * 即调用方法又调用缓存
     * CachePut和CacheAble的区别：
     * Cacheable先去缓存中查找数据
     * CachePut 先调用方法然后将结果放入缓存中
     * --------------一定要将cachePut中的key属性设置为与更新数据的key相同要不然不会更新，只会再添加一个键值对
     *
     * @param employee
     * @return
     */
    @CachePut(cacheNames = "emp", key = "#result.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("更新员工");
        empMapper.update(employee);
        return employee;
    }

    /**
     * @param id
     * @return 通过key指定要清除的key
     * allEntries删除缓存所有数据
     */
    @CacheEvict(cacheNames = "emp", key = "#id")
    public void deleteEmp(Integer id) {
        System.out.println("删除");
//        empMapper.delete(id);
    }

    @Caching(
            cacheable = {@Cacheable(cacheNames = "emp",key = "#lastName")},
            put = {
                    @CachePut(cacheNames = "emp",key = "#result.id"),
                    @CachePut(cacheNames = "emp",key = "#result.email")
            }
    )
    public Employee findByName(String lastName) {
        return empMapper.findByName(lastName);
    }

}
