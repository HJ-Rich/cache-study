package com.study.cache.domain;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface TeamRepository extends Repository<Team, Long> {
    void saveAll(Iterable<Team> teams);

    @Query("select t from Team t join fetch t.members")
    List<Team> findAll();

    @Query("select t from Team t join fetch t.members where t.id = :id")
    Optional<Team> findById(@Param("id") Long id);
}
