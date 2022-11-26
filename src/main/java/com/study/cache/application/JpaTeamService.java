package com.study.cache.application;

import com.study.cache.domain.Member;
import com.study.cache.domain.Team;
import com.study.cache.domain.TeamRepository;
import java.util.List;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class JpaTeamService implements TeamService {
    public static final String ALL_TEAMS_CACHE_KEY = "'allTeams'";

    private final TeamRepository teamRepository;

    public JpaTeamService(final TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Cacheable(cacheNames = "teams", key = ALL_TEAMS_CACHE_KEY)
    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Cacheable(cacheNames = "team", key = "#id")
    @Override
    public Team findById(final Long id) {
        return teamRepository.findById(id)
                .orElseThrow();
    }

    @Caching(evict = {
            @CacheEvict(cacheNames = "teams", key = ALL_TEAMS_CACHE_KEY),
            @CacheEvict(cacheNames = "team", key = "#teamId")
    })
    @Transactional
    @Override
    public void addMember(final Long teamId, final String memberName) {
        teamRepository.findById(teamId)
                .orElseThrow()
                .addMember(List.of(new Member(memberName)));
    }
}
