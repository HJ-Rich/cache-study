package com.study.cache.application;

import com.study.cache.domain.Team;
import java.util.List;

public interface TeamService {
    List<Team> findAll();
}
