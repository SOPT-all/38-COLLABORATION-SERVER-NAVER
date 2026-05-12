package com.sopt.collaboration.domain.home.controller;

import java.util.List;

public record RecommendationResponse(
        String title,
        List<Item> items
) {

    public record Item(
            Long itemId,
            String name,
            String imageUrl,
            Integer originalPrice,
            Integer discountRate,
            Integer discountedPrice,
            Boolean isTomorrowDelivery
    ) {
    }
}