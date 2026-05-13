package com.sopt.collaboration.domain.product.entity;

import com.sopt.collaboration.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "products")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_name", nullable = false)
    private String brandName;

    @Column(name = "thumbnail_image_url", nullable = false)
    private String thumbnailImageUrl;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "review_score", nullable = false)
    private Double reviewScore;

    @Column(name = "recent_review_score", nullable = false)
    private Double recentReviewScore;

    @Column(name = "review_count", nullable = false)
    private Integer reviewCount;

    @Column(name = "original_price", nullable = false)
    private Integer originalPrice;

    @Column(name = "sale_price", nullable = false)
    private Integer salePrice;

    @Column(name = "member_price", nullable = false)
    private Integer memberPrice;

    @Column(name = "discount_rate", nullable = false)
    private Integer discountRate;

    @Column(name = "coupon_available", nullable = false)
    private Boolean couponAvailable;

    @Column(name = "coupon_dday")
    private Integer couponDday;

    @Column(name = "unit_price")
    private Integer unitPrice;

    @Column(name = "unit_quantity")
    private Integer unitQuantity;

    @Column(name = "unit")
    private String unit;

    @Column(name = "free_delivery", nullable = false)
    private Boolean freeDelivery;

    @Column(name = "arrival_date", nullable = false)
    private LocalDate arrivalDate;

    @Column(name = "deadline_at")
    private LocalDateTime deadlineAt;

    @Column(name = "max_point", nullable = false)
    private Integer maxPoint;

    @Builder
    public Product(
            Long id,
            String brandName,
            String thumbnailImageUrl,
            String name,
            Double reviewScore,
            Double recentReviewScore,
            Integer reviewCount,
            Integer originalPrice,
            Integer salePrice,
            Integer memberPrice,
            Integer discountRate,
            Boolean couponAvailable,
            Integer couponDday,
            Integer unitPrice,
            Integer unitQuantity,
            String unit,
            Boolean freeDelivery,
            LocalDate arrivalDate,
            LocalDateTime deadlineAt,
            Integer maxPoint
    ) {
        this.id = id;
        this.brandName = brandName;
        this.thumbnailImageUrl = thumbnailImageUrl;
        this.name = name;
        this.reviewScore = reviewScore;
        this.recentReviewScore = recentReviewScore;
        this.reviewCount = reviewCount;
        this.originalPrice = originalPrice;
        this.salePrice = salePrice;
        this.memberPrice = memberPrice;
        this.discountRate = discountRate;
        this.couponAvailable = couponAvailable;
        this.couponDday = couponDday;
        this.unitPrice = unitPrice;
        this.unitQuantity = unitQuantity;
        this.unit = unit;
        this.freeDelivery = freeDelivery;
        this.arrivalDate = arrivalDate;
        this.deadlineAt = deadlineAt;
        this.maxPoint = maxPoint;
    }
}
