package com.sopt.collaboration.domain.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brandName;

    @Column(nullable = false)
    private String thumbnailImageUrl;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double reviewScore;

    @Column(nullable = false)
    private Double recentReviewScore;

    @Column(nullable = false)
    private Integer reviewCount;

    @Column(nullable = false)
    private Integer originalPrice;

    @Column(nullable = false)
    private Integer salePrice;

    @Column(nullable = false)
    private Integer memberPrice;

    @Column(nullable = false)
    private Integer discountRate;

    @Column(nullable = false)
    private Boolean couponAvailable;

    private Integer couponDday;

    private Integer unitPrice;

    private Integer unitQuantity;

    private String unit;

    @Column(nullable = false)
    private Boolean freeDelivery;

    @Column(nullable = false)
    private LocalDate arrivalDate;

    private LocalDateTime deadlineAt;

    @Column(nullable = false)
    private Integer maxPoint;
}