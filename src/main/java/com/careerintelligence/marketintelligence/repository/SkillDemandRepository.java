package com.careerintelligence.marketintelligence.repository;

import com.careerintelligence.marketintelligence.model.SkillDemand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface SkillDemandRepository extends JpaRepository<SkillDemand, Long> {

    List<SkillDemand> findByRoleId(Long roleId);


@Query("SELECT s FROM SkillDemand s ORDER BY s.demandScore DESC")
List<SkillDemand> findTopSkills();

}