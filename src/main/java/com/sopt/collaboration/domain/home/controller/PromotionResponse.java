package com.sopt.collaboration.domain.home.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "프로모션 목록 응답")
public record PromotionResponse(
        @Schema(description = "프로모션 목록", nullable = false)
        List<Promotion> promotions
) {

    @Schema(description = "프로모션 정보")
    public record Promotion(
            @Schema(description = "프로모션 ID", example = "301", nullable = false)
            Long promotionId,
            @Schema(description = "프로모션 태그명", example = "보장특가", nullable = false)
            String tag,
            @Schema(description = "프로모션 종료 일시 (ISO 8601)", example = "2026-05-23T23:59:59", nullable = false)
            String endsAt,
            @Schema(description = "프로모션 대상 상품 목록", nullable = false)
            List<Item> items
    ) {
    }

    @Schema(description = "프로모션 대상 상품")
    public record Item(
            @Schema(description = "상품 ID", example = "1007", nullable = false)
            Long itemId,
            @Schema(description = "상품명", example = "저당 매실청 600g", nullable = false)
            String name,
            @Schema(description = "상품 이미지 URL", example = "https://example.com/images/item/1007.jpg", nullable = false)
            String imageUrl,
            @Schema(description = "상품 부속 태그 (없으면 null)", example = "브랜드데이", nullable = true)
            String tag,
            @Schema(description = "정가", example = "14900", nullable = false)
            Integer originalPrice,
            @Schema(description = "할인율", example = "16", nullable = false)
            Integer discountRate,
            @Schema(description = "할인가", example = "12470", nullable = false)
            Integer discountedPrice,
            @Schema(description = "내일배송 여부", example = "true", nullable = false)
            Boolean isTomorrowDelivery
    ) {
    }
}
