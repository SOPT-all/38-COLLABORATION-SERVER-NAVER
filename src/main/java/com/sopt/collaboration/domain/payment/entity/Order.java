package com.sopt.collaboration.domain.payment.entity;

import com.sopt.collaboration.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "available_amount", nullable = false)
    private Integer availableAmount;

    @Column(name = "available_point", nullable = false)
    private Integer availablePoint;

    @Column(name = "available_money", nullable = false)
    private Integer availableMoney;

    @Column(name = "hidden_point", nullable = false)
    private Integer hiddenPoint;

    @Column(name = "all_use_amount", nullable = false)
    private Integer allUseAmount;
}