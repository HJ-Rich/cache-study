package com.study.cache.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "team_id", foreignKey = @ForeignKey(name = "fk_member_team_id"))
    private Team team;

    protected Member() {
    }

    public Member(final Long id, final String name, final Team team) {
        this.id = id;
        this.name = name;
        this.team = team;
    }

    public Member(final String name) {
        this(null, name, null);
    }

    public void joinTeam(final Team team) {
        this.team = team;
    }
}
