package com.sopt.collaboration.domain.product.repository;

import com.sopt.collaboration.domain.product.entity.CardBenefit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardBenefitRepository extends JpaRepository<CardBenefit, Long> {

    List<CardBenefit> findAllByProductId(Long productId);
}