package com.sopt.collaboration.domain.home.repository;

import com.sopt.collaboration.domain.home.entity.Promotion;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    List<Promotion> findByEndsAtAfterOrderByEndsAtAsc(LocalDateTime now);
}