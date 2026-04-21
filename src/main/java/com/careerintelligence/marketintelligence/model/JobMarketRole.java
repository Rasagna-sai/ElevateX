package com.careerintelligence.marketintelligence.model;

import jakarta.persistence.*;

@Entity
public class JobMarketRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;
    private String description;

    // getters & setters
    public Long getId() { return id; }

    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}