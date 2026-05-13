package com.sopt.collaboration.domain.product.controller;

import com.sopt.collaboration.domain.product.dto.response.ProductDetailResponse;
import com.sopt.collaboration.domain.product.service.ProductService;
import com.sopt.collaboration.global.response.ApiResponseBody;
import com.sopt.collaboration.global.response.SuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ApiResponseBody<ProductDetailResponse, Void> getProductDetail(
            @PathVariable Long productId
    ) {
        ProductDetailResponse response = productService.getProductDetail(productId);

        return ApiResponseBody.ok(SuccessCode.OK, response);
    }
}