package com.study.cache.domain;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface TeamRepository extends Repository<Team, Long> {
    void saveAll(Iterable<Team> teams);

    @Query("select t from Team t join fetch t.members")
    List<Team> findAll();
}
