package com.sopt.collaboration.domain.home.controller;

import com.sopt.collaboration.domain.home.service.HomeService;
import com.sopt.collaboration.global.response.ApiResponseBody;
import com.sopt.collaboration.global.response.SuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Home", description = "홈 화면 관련 API")
@RestController
@RequestMapping("/api/home")
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @Operation(summary = "관심사 비슷한 아이템 조회", description = "사용자의 관심사와 연관도가 높은 내일배송 상품을 개인화 추천하여 반환한다.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "요청 성공",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ApiResponseBody.class),
                            examples = @ExampleObject(value = """
                                    {
                                      "success": true,
                                      "status": 200,
                                      "message": "요청이 성공했습니다.",
                                      "data": {
                                        "title": "홍길동님의 최근 관심사와 비슷한 아이템",
                                        "items": [
                                          {
                                            "itemId": 10023,
                                            "name": "생크림 과일 모찌 참쌀 떡 딸기 모찌",
                                            "imageUrl": "https://example.com/images/item/10023.jpg",
                                            "originalPrice": 15900,
                                            "discountRate": 25,
                                            "discountedPrice": 11780,
                                            "isTomorrowDelivery": true
                                          }
                                        ]
                                      }
                                    }
                                    """)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "서버 내부 오류",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(value = """
                                    {
                                      "success": false,
                                      "status": 500,
                                      "message": "서버 내부 오류가 발생했습니다.",
                                      "code": "COM_500_001",
                                      "meta": {
                                        "path": "/api/home/recommendations",
                                        "timestamp": 1746835200000
                                      }
                                    }
                                    """)
                    )
            )
    })
    @GetMapping("/recommendations")
    public ResponseEntity<ApiResponseBody<RecommendationResponse, Void>> getRecommendations() {
        return ResponseEntity.ok(ApiResponseBody.ok(SuccessCode.OK, homeService.getRecommendations()));
    }

    @Operation(summary = "카테고리 조회", description = "홈 화면에 노출할 카테고리 목록을 반환한다. 기본 상위 10개, 전체 요청 시 25개를 반환한다.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "요청 성공",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ApiResponseBody.class),
                            examples = @ExampleObject(value = """
                                    {
                                      "success": true,
                                      "status": 200,
                                      "message": "요청이 성공했습니다.",
                                      "data": {
                                        "categories": [
                                          {
                                            "categoryId": 1,
                                            "name": "행사",
                                            "iconUrl": "https://example.com/icons/category/1.png"
                                          }
                                        ],
                                        "totalCount": 10,
                                        "isExpanded": false
                                      }
                                    }
                                    """)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "expand 파라미터 값이 유효하지 않음",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(value = """
                                    {
                                      "success": false,
                                      "status": 400,
                                      "message": "expand 파라미터 값이 유효하지 않습니다.",
                                      "code": "HOM_400_001",
                                      "meta": {
                                        "path": "/api/home/categories",
                                        "timestamp": 1746835200000
                                      }
                                    }
                                    """)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "서버 내부 오류",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(value = """
                                    {
                                      "success": false,
                                      "status": 500,
                                      "message": "서버 내부 오류가 발생했습니다.",
                                      "code": "COM_500_001",
                                      "meta": {
                                        "path": "/api/home/categories",
                                        "timestamp": 1746835200000
                                      }
                                    }
                                    """)
                    )
            )
    })
    @GetMapping("/categories")
    public ResponseEntity<ApiResponseBody<CategoryResponse, Void>> getCategories(
            @Parameter(
                    description = "전체 카테고리 노출 여부. `true` 입력 시 전체 25개 반환, `false` 또는 미입력 시 상위 10개 반환. 그 외 값은 400 (HOM_400_001).",
                    example = "false",
                    schema = @Schema(type = "string", allowableValues = {"true", "false"})
            )
            @RequestParam(required = false) String expand
    ) {
        return ResponseEntity.ok(ApiResponseBody.ok(SuccessCode.OK, homeService.getCategories(expand)));
    }

    @Operation(summary = "프로모션 조회", description = "홈 화면 타임딜 섹션에 노출할 시간 제한 특가 프로모션 목록을 반환한다. 활성(`ends_at > now`) 프로모션만 종료 임박순으로 반환한다.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "요청 성공",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ApiResponseBody.class),
                            examples = @ExampleObject(value = """
                                    {
                                      "success": true,
                                      "status": 200,
                                      "message": "요청이 성공했습니다.",
                                      "data": {
                                        "promotions": [
                                          {
                                            "promotionId": 301,
                                            "tag": "보장특가",
                                            "endsAt": "2026-05-23T23:59:59",
                                            "items": [
                                              {
                                                "itemId": 1007,
                                                "name": "저당 매실청 600g",
                                                "imageUrl": "https://i.ibb.co/JRy4F1gQ/2026-05-13-12-34-05.png",
                                                "tag": "브랜드데이",
                                                "originalPrice": 14900,
                                                "discountRate": 16,
                                                "discountedPrice": 12470,
                                                "isTomorrowDelivery": true
                                              }
                                            ]
                                          }
                                        ]
                                      }
                                    }
                                    """)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "활성화된 프로모션이 없음",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(value = """
                                    {
                                      "success": false,
                                      "status": 404,
                                      "message": "현재 활성화된 프로모션이 없습니다.",
                                      "code": "HOM_404_001",
                                      "meta": {
                                        "path": "/api/home/promotions",
                                        "timestamp": 1746835200000
                                      }
                                    }
                                    """)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "서버 내부 오류",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(value = """
                                    {
                                      "success": false,
                                      "status": 500,
                                      "message": "서버 내부 오류가 발생했습니다.",
                                      "code": "COM_500_001",
                                      "meta": {
                                        "path": "/api/home/promotions",
                                        "timestamp": 1746835200000
                                      }
                                    }
                                    """)
                    )
            )
    })
    @GetMapping("/promotions")
    public ResponseEntity<ApiResponseBody<PromotionResponse, Void>> getPromotions() {
        return ResponseEntity.ok(ApiResponseBody.ok(SuccessCode.OK, homeService.getPromotions()));
    }
}
