package com.careerintelligence.marketintelligence.model;

import jakarta.persistence.*;

@Entity
public class SkillDemand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillName;
    private Integer demandScore;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private JobMarketRole role;

    // getters & setters
    public Long getId() { return id; }

    public String getSkillName() { return skillName; }
    public void setSkillName(String skillName) { this.skillName = skillName; }

    public Integer getDemandScore() { return demandScore; }
    public void setDemandScore(Integer demandScore) { this.demandScore = demandScore; }

    public JobMarketRole getRole() { return role; }
    public void setRole(JobMarketRole role) { this.role = role; }
}