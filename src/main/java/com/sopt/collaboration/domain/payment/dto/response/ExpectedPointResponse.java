package com.sopt.collaboration.domain.payment.dto.response;

public record ExpectedPointResponse(
        Integer totalPoint,
        PurchasePointResponse purchasePoint,
        Integer reviewPoint,
        Integer membershipPoint
) {
}
