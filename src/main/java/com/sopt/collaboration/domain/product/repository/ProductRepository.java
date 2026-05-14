package com.sopt.collaboration.domain.product.repository;

import com.sopt.collaboration.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}