package com.study.cache.presentation;

import com.study.cache.application.TeamService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/teams")
@RestController
public class TeamController {
    private final TeamService teamService;

    public TeamController(final TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/addMember")
    public void addMember(@RequestParam final Long teamId, @RequestParam final String memberName) {
        teamService.addMember(teamId, memberName);
    }

    @GetMapping
    public List<TeamResponse> findAll() {
        return teamService.findAll()
                .stream()
                .map(TeamResponse::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TeamResponse findById(@PathVariable Long id) {
        return TeamResponse.from(teamService.findById(id));
    }
}
