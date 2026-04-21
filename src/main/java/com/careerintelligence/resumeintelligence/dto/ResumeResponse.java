package com.careerintelligence.resumeintelligence.dto;
import java.util.List;

public class ResumeResponse {
	private List<String> extractedSkills;

    public ResumeResponse(List<String> extractedSkills) {
        this.extractedSkills = extractedSkills;
    }

    public List<String> getExtractedSkills() {
        return extractedSkills;
    }
}
