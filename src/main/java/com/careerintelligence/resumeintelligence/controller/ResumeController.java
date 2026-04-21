package com.careerintelligence.resumeintelligence.controller;

import com.careerintelligence.resumeintelligence.dto.ResumeResponse;
import com.careerintelligence.resumeintelligence.service.ResumeService;
import com.careerintelligence.resumeintelligence.dto.FullAnalysisResponse;
import org.springframework.web.bind.annotation.*;
import com.careerintelligence.resumeintelligence.dto.ResumeRequest;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/resume")
public class ResumeController {
	  private final ResumeService service;

	    public ResumeController(ResumeService service) {
	        this.service = service;
	    }

	    @PostMapping("/analyze")
	    public ResumeResponse analyzeResume(@RequestBody String resumeText) {

	        List<String> skills = service.extractSkills(resumeText);

	        return new ResumeResponse(skills);
	    }

	    @PostMapping("/full-analysis/{roleId}")
	    public FullAnalysisResponse fullAnalysis(
	            @PathVariable Long roleId,
	            @RequestBody ResumeRequest request
	    ) {
	        return service.fullAnalysis(roleId, request.getResumeText());
	    }
}
