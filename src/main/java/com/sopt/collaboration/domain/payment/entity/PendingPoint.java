package com.sopt.collaboration.domain.payment.entity;

import com.sopt.collaboration.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "pending_points")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PendingPoint extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "total_point", nullable = false)
    private Integer totalPoint;

    @Column(name = "purchase_total_point", nullable = false)
    private Integer purchaseTotalPoint;

    @Column(name = "basic_point", nullable = false)
    private Integer basicPoint;

    @Column(name = "npay_money_point", nullable = false)
    private Integer npayMoneyPoint;

    @Column(name = "review_point", nullable = false)
    private Integer reviewPoint;

    @Column(name = "membership_point", nullable = false)
    private Integer membershipPoint;
}