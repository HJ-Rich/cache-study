package com.study.cache.presentation;

import com.study.cache.domain.Team;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;

@Getter
public class TeamResponse {
    private Long id;
    private String name;
    private List<MemberResponse> members;

    @Builder
    public TeamResponse(final Long id, final String name, final List<MemberResponse> members) {
        this.id = id;
        this.name = name;
        this.members = members;
    }

    public static TeamResponse from(final Team team) {
        final var members = team.getMembers()
                .stream()
                .map(MemberResponse::from)
                .collect(Collectors.toList());

        return TeamResponse.builder()
                .id(team.getId())
                .name(team.getName())
                .members(members)
                .build();
    }
}
