package Jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {
    @Test  //1. String操作
    public void test1() {
        //1。获取连接
        Jedis j = new Jedis("localhost");
        //2.操作
        j.set("username","niuben");
        String username = j.get("username");
        System.out.println(username);
        j.close();

        //设置过期时间
        j.setex("checkcode",30,"123456");


    }

    @Test  //2. Hash操作
    public void test2() {
        //1。获取连接
        Jedis j = new Jedis("localhost");
        //2.操作
        j.hset("user","name","张三");
        j.hset("user", "age", "22");
        j.hset("user", "gender", "nan");
        String hget = j.hget("user", "name");
//        System.out.println(hget);

        //获取所有
        Map<String, String> map = j.hgetAll("user");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        j.close();
    }

    @Test  //3. List操作
    public void test3() {
        Jedis j = new Jedis();
        j.lpush("mylist", "a", "b", "c");  //左添加
        j.rpush("mylist", "a", "b", "c");  //右添加
        List<String> mylist = j.lrange("mylist", 0, -1);
        System.out.println(mylist);
        //弹出
        String mylist1 = j.lpop("mylist");
        System.out.println(mylist1);
        j.close();
    }

    @Test  //4. Set操作
    public void test4() {
        Jedis j = new Jedis();
        j.sadd("mySet", "Java", "Python", "C++");  //添加
        Set<String> mySet = j.smembers("mySet");   //获取所有
        System.out.println(mySet);
        j.close();
    }

    @Test  //5. 有序Set操作
    public void test5() {
        Jedis j = new Jedis();
        j.zadd("mysortset",3,"Java");
        j.zadd("mysortset",2,"Python");
        j.zadd("mysortset",1,"C");
        Set<String> mysortset = j.zrange("mysortset", 0, -1);
        System.out.println(mysortset);
        j.close();
    }

    /*连接池
        1.创建连接池对象
        2.获取连接  getResource()
        3.使用
     */
@Test
    public void test6() {
    JedisPool jedisPool = new JedisPool();
    Jedis resource = jedisPool.getResource();
    resource.set("hehe","haha");
    resource.close();  //归还给连接池
}
}
