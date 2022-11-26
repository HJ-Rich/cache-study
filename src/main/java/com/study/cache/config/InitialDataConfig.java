package com.study.cache.config;

import com.study.cache.domain.Member;
import com.study.cache.domain.Team;
import com.study.cache.domain.TeamRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitialDataConfig {
    private final TeamRepository teamRepository;

    public InitialDataConfig(final TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @PostConstruct
    public void setup() {
        final var baseball = new Team("야구팀");
        baseball.addMember(List.of(new Member("이종범"), new Member("이정후")));

        final var soccer = new Team("축구팀");
        soccer.addMember(List.of(new Member("차범근"), new Member("손흥민")));

        teamRepository.saveAll(List.of(baseball, soccer));
    }
}
