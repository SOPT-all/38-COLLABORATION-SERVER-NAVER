package com.sopt.collaboration.domain.home.repository;

import com.sopt.collaboration.domain.home.entity.RecommendationSection;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationSectionRepository extends JpaRepository<RecommendationSection, Long> {

    Optional<RecommendationSection> findByUser_Id(Long userId);
}