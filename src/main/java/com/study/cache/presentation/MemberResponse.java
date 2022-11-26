package com.study.cache.presentation;

import com.study.cache.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberResponse {
    private Long id;
    private String name;

    @Builder
    public MemberResponse(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public static MemberResponse from(final Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .build();
    }
}
