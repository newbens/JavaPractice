package com.niuben.springbootcache;

import com.niuben.springbootcache.bean.Employee;
import com.niuben.springbootcache.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.yaml.snakeyaml.events.Event;

@SpringBootTest
class SpringBootCacheApplicationTests {

    @Autowired
    EmpMapper empMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<Object,Employee> empredisTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    public void testEmpFindById() {
        Employee byId = empMapper.findById(1);
        System.out.println(byId);
    }

    @Test
    public void testEmpInsert() {
        Employee employee = new Employee();
        employee.setLastName("牛犇");
        employee.setGender(1);
        employee.setEmail("newbens@163.com");
        employee.setdId(1);
        empMapper.insert(employee);
    }

    @Test
    /**
     *  opsForValue()操作字符串的
     *  opsForList()操作列表
     *  opsForSet()操作集合
     *  opsForHash()操作哈希
     *  opsForZSet()操作有序集合
     */
    public void testRedis1() {
//        stringRedisTemplate.opsForValue().append("test","testOpsForValue");
//        String test = stringRedisTemplate.opsForValue().get("test");
//        System.out.println(test);
        stringRedisTemplate.opsForList().leftPush("testList","1");
        stringRedisTemplate.opsForList().leftPush("testList","2");
        stringRedisTemplate.opsForList().leftPush("testList","3");
        stringRedisTemplate.opsForList().leftPush("testList","4");
        stringRedisTemplate.opsForList().leftPush("testList","5");

    }

    @Test //测试保存对象
    public void testRedis2() {
        Employee emp = empMapper.findById(1);
//        empredisTemplate.opsForValue().set("emp_1",emp);
        //将数据以json形式保存
        Employee employee = empredisTemplate.opsForValue().get("emp_1");
        System.out.println(employee);
    }











}
