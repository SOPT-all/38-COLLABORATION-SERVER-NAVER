package com.sopt.collaboration.domain.product.repository;

import com.sopt.collaboration.domain.home.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}