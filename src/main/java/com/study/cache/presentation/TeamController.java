package com.study.cache.presentation;

import com.study.cache.application.TeamService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/teams")
@RestController
public class TeamController {
    private final TeamService teamService;

    public TeamController(final TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<TeamResponse> teams() {
        return teamService.findAll()
                .stream()
                .map(TeamResponse::from)
                .collect(Collectors.toList());
    }
}
