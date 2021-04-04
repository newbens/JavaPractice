package com.niuben;

import com.niuben.dao.RoleDao;
import com.niuben.dao.UserDao;
import com.niuben.domain.Role;
import com.niuben.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestMybaties {

    private InputStream in;
    private SqlSession sqlSession;
    private RoleDao roleDao;
    private UserDao userDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        sqlSession = factory.openSession();
        roleDao = sqlSession.getMapper(RoleDao.class);
        userDao = sqlSession.getMapper(UserDao.class);


    }

    @After
    public void destory() throws Exception {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }


    @Test
    public void testFindAll() {
        List<Role> all = roleDao.findAll();
        for (Role role : all) {
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
    @Test
    public void testUserFindAll() {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getRole());
        }
    }



}

