package com.sopt.collaboration.domain.product.dto.response;

public record DeliveryResponse(
        Boolean isFreeDelivery,
        String arrivalDate,
        String deadlineAt
) {
}