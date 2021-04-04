package com.niuben;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTX {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.12.129",6380);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello", "world");
        jsonObject.put("name", "niuben");
        //开启事务
        Transaction transaction = jedis.multi();
        String res = jsonObject.toJSONString();
        try {
            transaction.set("user1", res);
            transaction.set("user2", "123");
            transaction.exec();//执行事务
        } catch (Exception e) {
            transaction.discard();//放弃事务
            e.printStackTrace();
        }finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();//关闭连接
        }
    }
}
