package com.niuben;

import redis.clients.jedis.Jedis;

public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.12.129",6380);
        System.out.println(jedis.ping());
    }
}
