package com.sopt.collaboration.domain.home.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(description = "카테고리 목록 응답")
public record CategoryResponse(
        @Schema(description = "카테고리 목록", nullable = false)
        List<Category> categories,
        @Schema(description = "반환된 카테고리 수", example = "10", nullable = false)
        Integer totalCount,
        @Schema(description = "전체 카테고리 노출 여부", example = "false", nullable = false)
        Boolean isExpanded
) {

    @Schema(description = "카테고리 정보")
    public record Category(
            @Schema(description = "카테고리 ID", example = "1", nullable = false)
            Long categoryId,
            @Schema(description = "카테고리명", example = "행사", nullable = false)
            String name,
            @Schema(description = "카테고리 아이콘 이미지 URL", example = "https://example.com/icons/category/1.png", nullable = false)
            String iconUrl
    ) {
    }
}
