package com.careerintelligence.marketintelligence.dto;

import java.util.List;
public class SkillGapResponse {

    private List<String> matchedSkills;
    private List<String> missingSkills;
    private List<String> topRecommendations;
    private double readiness;

    // Constructor
    public SkillGapResponse(List<String> matchedSkills,
            List<String> missingSkills,
            double readiness,
            List<String> topRecommendations) {
this.matchedSkills = matchedSkills;
this.missingSkills = missingSkills;
this.readiness = readiness;
this.topRecommendations = topRecommendations;
}

    // Getters
    public List<String> getMatchedSkills() {
        return matchedSkills;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }

    public double getReadiness() {
        return readiness;
    }
    public List<String> getTopRecommendations() {
        return topRecommendations;
    }

    // Setters (optional but good practice)
    public void setMatchedSkills(List<String> matchedSkills) {
        this.matchedSkills = matchedSkills;
    }

    public void setMissingSkills(List<String> missingSkills) {
        this.missingSkills = missingSkills;
    }

    public void setReadiness(double readiness) {
        this.readiness = readiness;
    }
}