package com.sopt.collaboration.domain.payment.repository;

import com.sopt.collaboration.domain.payment.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
