package com.marcola.tieasaaiapp.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.awt.print.Book;

@Configuration
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
}
