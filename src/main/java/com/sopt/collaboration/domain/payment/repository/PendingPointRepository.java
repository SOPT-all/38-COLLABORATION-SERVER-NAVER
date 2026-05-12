package com.sopt.collaboration.domain.payment.repository;

import com.sopt.collaboration.domain.payment.entity.PendingPoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PendingPointRepository extends JpaRepository<PendingPoint, Long> {

    Optional<PendingPoint> findByOrderId(Long orderId);
}
