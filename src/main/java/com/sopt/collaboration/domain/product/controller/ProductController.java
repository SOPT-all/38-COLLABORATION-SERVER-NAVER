package com.sopt.collaboration.domain.product.controller;

import com.sopt.collaboration.domain.product.dto.response.ProductDetailResponse;
import com.sopt.collaboration.domain.product.service.ProductService;
import com.sopt.collaboration.global.response.ApiResponseBody;
import com.sopt.collaboration.global.response.SuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Product", description = "상품 상세 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "상품 상세 조회 API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "상품 상세 조회 성공"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 상품"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })
    @GetMapping("/{productId}")
    public ApiResponseBody<ProductDetailResponse, Void> getProductDetail(
            @PathVariable Long productId
    ) {

        ProductDetailResponse response = productService.getProductDetail(productId);

        return ApiResponseBody.ok(
                SuccessCode.OK,
                response
        );
    }
}