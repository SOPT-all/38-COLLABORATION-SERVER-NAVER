package com.sopt.collaboration.domain.home.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "추천 상품 목록 응답")
public record RecommendationResponse(
        @Schema(description = "사용자 닉네임이 포함된 섹션 소제목", example = "홍길동님의 최근 관심사와 비슷한 아이템", nullable = false)
        String title,
        @Schema(description = "추천 상품 목록", nullable = false)
        List<Item> items
) {

    @Schema(description = "추천 상품 정보")
    public record Item(
            @Schema(description = "상품 ID", example = "10023", nullable = false)
            Long itemId,
            @Schema(description = "상품명", example = "생크림 과일 모찌 참쌀 떡 딸기 모찌", nullable = false)
            String name,
            @Schema(description = "상품 이미지 URL", example = "https://example.com/images/item/10023.jpg", nullable = false)
            String imageUrl,
            @Schema(description = "정가", example = "15900", nullable = false)
            Integer originalPrice,
            @Schema(description = "할인율 (없으면 0)", example = "25", nullable = false)
            Integer discountRate,
            @Schema(description = "할인가", example = "11780", nullable = false)
            Integer discountedPrice,
            @Schema(description = "내일배송 여부", example = "true", nullable = false)
            Boolean isTomorrowDelivery
    ) {
    }
}