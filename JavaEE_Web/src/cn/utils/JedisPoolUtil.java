package cn.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
//工具类
public class JedisPoolUtil {
    private static JedisPool jedisPool;
    static {
        InputStream is =JedisPoolUtil.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //设置参数
        jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        jedisPoolConfig.setMaxIdle((Integer) properties.get("maxIdle"));
        jedisPool = new JedisPool(jedisPoolConfig,properties.getProperty("host"), (Integer) properties.get("port"));
    }
    public static Jedis getConnection() {
        return jedisPool.getResource();
    }
}
class test{
    public static void main(String[] args) {
        Jedis connection = JedisPoolUtil.getConnection();
        connection.set("***", "***");
    }
}
