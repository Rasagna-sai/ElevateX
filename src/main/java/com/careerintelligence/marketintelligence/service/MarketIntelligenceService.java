package com.careerintelligence.marketintelligence.service;

import com.careerintelligence.marketintelligence.model.JobMarketRole;
import com.careerintelligence.marketintelligence.model.SkillDemand;
import com.careerintelligence.marketintelligence.repository.JobMarketRoleRepository;
import com.careerintelligence.marketintelligence.repository.SkillDemandRepository;
import org.springframework.stereotype.Service;
import com.careerintelligence.marketintelligence.dto.SkillGapResponse;
import java.util.List;

@Service
public class MarketIntelligenceService {

    private final JobMarketRoleRepository roleRepository;
    private final SkillDemandRepository skillRepository;

    public MarketIntelligenceService(JobMarketRoleRepository roleRepository,
                                     SkillDemandRepository skillRepository) {
        this.roleRepository = roleRepository;
        this.skillRepository = skillRepository;
    }

    public JobMarketRole createRole(JobMarketRole role) {
        return roleRepository.save(role);
    }

    public List<JobMarketRole> getAllRoles() {
        return roleRepository.findAll();
    }

    public SkillDemand addSkillDemand(SkillDemand skill) {
        return skillRepository.save(skill);
    }

    public List<SkillDemand> getSkillsByRole(Long roleId) {
        return skillRepository.findByRoleId(roleId);
    }
    public List<SkillDemand> getTrendingSkills() {
    return skillRepository.findTopSkills();
    }
    public SkillGapResponse analyzeSkillGap(Long roleId, List<String> userSkills) {

        List<SkillDemand> requiredSkills = skillRepository.findByRoleId(roleId);

        List<String> user = userSkills.stream()
                .map(String::toLowerCase)
                .toList();

        List<String> matched = requiredSkills.stream()
                .map(skill -> skill.getSkillName().toLowerCase())
                .filter(user::contains)
                .toList();

        List<String> missing = requiredSkills.stream()
                .map(skill -> skill.getSkillName().toLowerCase())
                .filter(skill -> !user.contains(skill))
                .toList();
        List<String> topRecommendations = requiredSkills.stream()
                .filter(skill -> !user.contains(skill.getSkillName().toLowerCase()))
                .sorted((a, b) -> Double.compare(b.getDemandScore(), a.getDemandScore()))
                .limit(5)
                .map(skill -> skill.getSkillName() + " (" + skill.getDemandScore() + ")")
                .toList();

        double totalDemand = requiredSkills.stream()
                .mapToDouble(SkillDemand::getDemandScore)
                .sum();

        double matchedDemand = requiredSkills.stream()
                .filter(skill -> user.contains(skill.getSkillName().toLowerCase()))
                .mapToDouble(SkillDemand::getDemandScore)
                .sum();

        double readiness = 0;
        if (totalDemand > 0) {
            readiness = (matchedDemand / totalDemand) * 100;
        }

        return new SkillGapResponse(matched, missing, readiness, topRecommendations);
    }

}
