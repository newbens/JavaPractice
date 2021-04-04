package com.niuben.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.http.codec.cbor.Jackson2CborDecoder;

import java.net.UnknownHostException;

@Configuration
public class RedisConfig {
    //自定义配置
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        //配置具体序列化方式
        Jackson2JsonRedisSerializer<Object> js = new Jackson2JsonRedisSerializer<>(Object.class);
        template.setKeySerializer(js);


        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
