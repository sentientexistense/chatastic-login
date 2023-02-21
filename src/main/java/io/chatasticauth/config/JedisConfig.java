package io.chatasticauth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class JedisConfig {
    @Value("${spring.data.redis.host}")
    private String hostName;
    @Value("${spring.data.redis.port}")
    private int port;

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory(new RedisStandaloneConfiguration(hostName, port));
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}
