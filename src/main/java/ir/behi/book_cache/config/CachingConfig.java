package ir.behi.book_cache.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;

@Configuration
@EnableCaching
@Slf4j
@ConditionalOnProperty(value="resolved.cache.enabled", havingValue = "true", matchIfMissing = true)
public class CachingConfig {
    @Value("${resolved.cache.ttl:30}")
    private long ttlInMinutes;

    @Value("${ENV:env}")
    private String environment;

    private static final String API_PREFIX = "my-book-app";
    private static final String SEPARATOR = ":";

    @Bean
    public CacheManager cacheManager(LettuceConnectionFactory lettuceConnectionFactory) {
        log.info("[Cache] injecting TTL cache: enabled");
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .disableCachingNullValues()
                .entryTtl(Duration.ofMinutes(ttlInMinutes))
                .computePrefixWith(cacheName -> API_PREFIX.concat(SEPARATOR).concat(environment).concat(SEPARATOR)
                        .concat(cacheName).concat(SEPARATOR)) // cache key prefix with the environment
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()));
        redisCacheConfiguration.usePrefix();

        return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(lettuceConnectionFactory)
                .cacheDefaults(redisCacheConfiguration).build();
    }
}
