package com.sopt.collaboration.domain.payment.service;

import com.sopt.collaboration.domain.payment.dto.response.ExpectedPointResponse;
import com.sopt.collaboration.domain.payment.dto.response.PointResponse;
import com.sopt.collaboration.domain.payment.dto.response.PurchasePointResponse;
import com.sopt.collaboration.domain.payment.entity.Order;
import com.sopt.collaboration.domain.payment.entity.PendingPoint;
import com.sopt.collaboration.domain.payment.exception.OrderNotFoundException;
import com.sopt.collaboration.domain.payment.repository.OrderRepository;
import com.sopt.collaboration.domain.payment.repository.PendingPointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PaymentService {

    private final OrderRepository orderRepository;
    private final PendingPointRepository pendingPointRepository;

    public PointResponse getOrderPoints(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(OrderNotFoundException::new);

        PendingPoint pendingPoint = pendingPointRepository.findByOrderId(orderId)
                .orElseThrow(OrderNotFoundException::new);

        PurchasePointResponse purchasePoint = new PurchasePointResponse(
                pendingPoint.getPurchaseTotalPoint(),
                pendingPoint.getBasicPoint(),
                pendingPoint.getNpayMoneyPoint()
        );

        ExpectedPointResponse expectedPoint = new ExpectedPointResponse(
                pendingPoint.getTotalPoint(),
                purchasePoint,
                pendingPoint.getReviewPoint(),
                pendingPoint.getMembershipPoint()
        );

        return new PointResponse(
                order.getId(),
                order.getAvailableAmount(),
                order.getAvailablePoint(),
                order.getAvailableMoney(),
                order.getHiddenPoint(),
                order.getAllUseAmount(),
                expectedPoint
        );
    }
}