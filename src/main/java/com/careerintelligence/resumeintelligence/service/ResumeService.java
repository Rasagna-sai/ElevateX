package com.careerintelligence.resumeintelligence.service;

import org.springframework.stereotype.Service;
import com.careerintelligence.marketintelligence.service.MarketIntelligenceService;
import com.careerintelligence.marketintelligence.dto.SkillGapResponse;
import com.careerintelligence.resumeintelligence.dto.FullAnalysisResponse;

import java.util.Arrays;
import java.util.List;

@Service

public class ResumeService {
	private static final List<String> KNOWN_SKILLS = Arrays.asList(
            "java", "spring boot", "sql", "python", "html", "css", "javascript"
    );

    public List<String> extractSkills(String resumeText) {

        String lowerText = resumeText.toLowerCase();

        return KNOWN_SKILLS.stream()
                .filter(lowerText::contains)
                .toList();
    }
    private final MarketIntelligenceService marketService;

    public ResumeService(MarketIntelligenceService marketService) {
        this.marketService = marketService;
    }
    
    public FullAnalysisResponse fullAnalysis(Long roleId, String resumeText) {

        List<String> extractedSkills = extractSkills(resumeText);

        SkillGapResponse gap = marketService.analyzeSkillGap(roleId, extractedSkills);

        String summary;

        if (gap.getReadiness() > 80) {
            summary = "You are highly ready for this role.";
        } else if (gap.getReadiness() > 50) {
            summary = "You are moderately ready. Improve key skills.";
        } else {
            summary = "You need significant improvement to match this role.";
        }

        return new FullAnalysisResponse(
                extractedSkills,
                gap.getMatchedSkills(),
                gap.getMissingSkills(),
                gap.getReadiness(),
                gap.getTopRecommendations(),
                summary
        );
    }
}
