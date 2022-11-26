package com.study.cache.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Member> members = new ArrayList<>();

    protected Team() {
    }

    public Team(final Long id, final String name, final List<Member> members) {
        this.id = id;
        this.name = name;
        this.members = members;
    }

    public Team(final String name) {
        this(null, name, new ArrayList<>());
    }

    public void addMember(final List<Member> members) {
        this.members.addAll(members);
        members.forEach(member -> member.joinTeam(this));
    }
}
