package com.sopt.collaboration.domain.product.dto.response;

public record ProductDetailResponse(

        Long productId,
        String brandName,
        String thumbnailImageUrl,
        String productName,

        Double reviewScore,
        Double recentReviewScore,
        Integer reviewCount,

        Integer discountRate,
        Integer originalPrice,
        Integer salePrice,
        Integer memberPrice,

        Boolean couponAvailable,
        Integer couponDday,

        Integer unitPrice,
        Integer unitQuantity,
        String unit,

        DeliveryResponse delivery,
        PointBenefitResponse pointBenefit
) {
}
