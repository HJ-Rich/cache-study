package com.study.cache.application;

import com.study.cache.domain.Team;
import com.study.cache.domain.TeamRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class JpaTeamService implements TeamService {
    private final TeamRepository teamRepository;

    public JpaTeamService(final TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }
}
