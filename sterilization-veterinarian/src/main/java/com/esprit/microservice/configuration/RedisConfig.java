package com.esprit.microservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class RedisConfig {
    
    @Value("${spring.redis.host}")
    private String REDIS_HOST;
    @Value("${spring.redis.port}")
    private Integer REDIS_PORT;

	@Bean
	  public RedisConnectionFactory connectionFactory() {
        
	    RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("redis", REDIS_PORT);
	    return new JedisConnectionFactory(config);
	  }

	  @Bean
	  public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

	    RedisTemplate<byte[], byte[]> template = new RedisTemplate<byte[], byte[]>();
	    template.setConnectionFactory(redisConnectionFactory);
	    return template;
	  }

}