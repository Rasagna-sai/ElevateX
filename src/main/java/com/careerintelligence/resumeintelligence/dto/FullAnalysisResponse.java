package com.careerintelligence.resumeintelligence.dto;


import java.util.List;

public class FullAnalysisResponse {

    private List<String> extractedSkills;
    private List<String> matchedSkills;
    private List<String> missingSkills;
    private double readiness;
    private List<String> topRecommendations;
    private String summary;

    public FullAnalysisResponse(List<String> extractedSkills,
                                List<String> matchedSkills,
                                List<String> missingSkills,
                                double readiness,
                                List<String> topRecommendations,
                                String summary) {
        this.extractedSkills = extractedSkills;
        this.matchedSkills = matchedSkills;
        this.missingSkills = missingSkills;
        this.readiness = readiness;
        this.topRecommendations = topRecommendations;
        this.summary = summary;
    }
    public String getSummary() {
        return summary;
    }

    public List<String> getExtractedSkills() {
        return extractedSkills;
    }

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
}