package com.niuben;

import com.niuben.dao.UserDao;
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
import java.util.Date;
import java.util.List;

public class TestMybaties {

    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);

    }

    @After
    public void destory() throws Exception {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void test1() {
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setUsername("TestSave");
        user.setAddress("宝鸡市岐山县");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.saveUser(user);
    }

    @Test
    public void testUpdate() throws Exception {
        User user = new User();
        user.setId(48);
        user.setUsername("mybatiesUpdate");
        user.setAddress("宝鸡市岐山县");
        user.setSex("女");
        user.setBirthday(new Date());
        userDao.update(user);
    }

    @Test
    public void testDelete() throws Exception {
        Integer id = 42;
        userDao.delete(id);
    }

    @Test
    public void testFindById() throws Exception {
        Integer id = 43;
        User byId = userDao.findById(id);
        System.out.println(byId);
    }

    @Test
    public void testFindByName() throws Exception {
        List<User> byName = userDao.findByName("%Test%");
        for (User user : byName) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() throws Exception {
        int total = userDao.findTotal();
        System.out.println(total);
    }
}

