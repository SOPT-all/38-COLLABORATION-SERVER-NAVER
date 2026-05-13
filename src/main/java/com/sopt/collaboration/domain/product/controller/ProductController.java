package com.sopt.collaboration.domain.product.controller;

import com.sopt.collaboration.domain.product.dto.response.ProductDetailResponse;
import com.sopt.collaboration.domain.product.service.ProductService;
import com.sopt.collaboration.global.response.ApiResponseBody;
import com.sopt.collaboration.global.response.SuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
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
            @ApiResponse(
                    responseCode = "200",
                    description = "상품 상세 조회 성공"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "존재하지 않는 상품",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                        {
                                          "success": false,
                                          "status": 404,
                                          "message": "존재하지 않는 상품입니다.",
                                          "code": "PRD_404_001",
                                          "meta": {
                                            "path": "/api/products/1001",
                                            "timestamp": 1746835200000
                                          }
                                        }
                                        """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "서버 내부 오류",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                        {
                                          "success": false,
                                          "status": 500,
                                          "message": "서버 내부 오류가 발생했습니다.",
                                          "code": "COM_500_001",
                                          "meta": {
                                            "path": "/api/products/1001",
                                            "timestamp": 1746835200000
                                          }
                                        }
                                        """
                            )
                    )
            )
    })
    @GetMapping("/{productId}")
    public ApiResponseBody<ProductDetailResponse, Void> getProductDetail(
            @Parameter(
                    description = "상품 ID",
                    example = "10023"
            )
            @PathVariable Long productId
    ) {

        ProductDetailResponse response = productService.getProductDetail(productId);

        return ApiResponseBody.ok(
                SuccessCode.OK,
                response
        );
    }
}