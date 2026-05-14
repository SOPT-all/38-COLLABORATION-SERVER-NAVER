package com.sopt.collaboration.domain.payment.dto.response;

public record PointResponse(
        Long orderId,
        Integer availableAmount,
        Integer availablePoint,
        Integer availableMoney,
        Integer hiddenPoint,
        Integer allUseAmount,
        Integer deferredPaymentAvailableAmount,
        ExpectedPointResponse expectedPoint
) {
}