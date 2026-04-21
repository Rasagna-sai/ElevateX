package com.careerintelligence.marketintelligence.controller;

import com.careerintelligence.marketintelligence.dto.SkillGapResponse;
import com.careerintelligence.marketintelligence.model.JobMarketRole;
import com.careerintelligence.marketintelligence.model.SkillDemand;
import com.careerintelligence.marketintelligence.service.MarketIntelligenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/market")
public class MarketIntelligenceController {

    private final MarketIntelligenceService service;

    public MarketIntelligenceController(MarketIntelligenceService service) {
        this.service = service;
    }

    @PostMapping("/roles")
    public JobMarketRole createRole(@RequestBody JobMarketRole role) {
        return service.createRole(role);
    }

    @GetMapping("/roles")
    public List<JobMarketRole> getRoles() {
        return service.getAllRoles();
    }

    @PostMapping("/skills")
    public SkillDemand addSkill(@RequestBody SkillDemand skill) {
        return service.addSkillDemand(skill);
    }

    @GetMapping("/skills/{roleId}")
    public List<SkillDemand> getSkills(@PathVariable Long roleId) {
        return service.getSkillsByRole(roleId);
    }
    @GetMapping("/trending-skills")
    public List<SkillDemand> getTrendingSkills() {
        return service.getTrendingSkills();
    }
    @GetMapping("/skill-gap/{roleId}")
    public SkillGapResponse getSkillGap(
            @PathVariable Long roleId,
            @RequestParam List<String> skills
    ) {
    	return service.analyzeSkillGap(roleId, skills);
    }
}
