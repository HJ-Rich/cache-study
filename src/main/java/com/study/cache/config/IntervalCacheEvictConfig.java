package com.study.cache.config;

import static com.study.cache.application.JpaTeamService.ALL_TEAMS_CACHE_KEY;

import java.util.Objects;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class IntervalCacheEvictConfig {
    private final CacheManager cacheManager;

    public IntervalCacheEvictConfig(final CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @CacheEvict(cacheNames = "teams", key = ALL_TEAMS_CACHE_KEY)
    @Scheduled(fixedDelay = 5000)
    public void evictByAnnotation() {
    }

    @Scheduled(fixedDelay = 7000)
    public void evictByCacheManager() {
        final var teams = cacheManager.getCache("teams");
        if (Objects.nonNull(teams)) {
            teams.clear();
        }
    }
}
