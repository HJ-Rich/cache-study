package com.study.cache.config;

import static com.study.cache.application.JpaTeamService.ALL_TEAMS_CACHE_KEY;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
public class IntervalCacheEvictConfig {
    @CacheEvict(cacheNames = "teams", key = ALL_TEAMS_CACHE_KEY)
    @Scheduled(fixedDelay = 10000)
    public void evict() {
        System.out.println("evict cache...");
    }
}
