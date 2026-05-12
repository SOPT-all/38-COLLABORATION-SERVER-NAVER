package com.sopt.collaboration.domain.payment.dto.response;

public record PurchasePointResponse(
        Integer total,
        Integer basicPoint,
        Integer npayMoneyPoint
) {
}
