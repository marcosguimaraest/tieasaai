package com.marcola.tieasaaiapp.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import java.awt.print.Book;

@Configuration
@EnableRedisRepositories
public class RadisConfiguration {
    @Value("${REDIS_HOST}")
    public String hostname;
    @Value("${REDIS_PORT}")
    public int port;
    @Value("${REDIS_PASSWORD}")
    public String password;

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration rsc = new RedisStandaloneConfiguration(hostname, port);
        rsc.setUsername("default");
        rsc.setPassword(password);
        return new LettuceConnectionFactory(rsc);
    }
    @Bean
    public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

        RedisTemplate<byte[], byte[]> template = new RedisTemplate<byte[], byte[]>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
