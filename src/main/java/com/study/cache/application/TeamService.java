package com.study.cache.application;

import com.study.cache.domain.Team;
import java.util.List;

public interface TeamService {
    void addMember(Long teamId, String memberName);

    List<Team> findAll();

    Team findById(Long id);
}
