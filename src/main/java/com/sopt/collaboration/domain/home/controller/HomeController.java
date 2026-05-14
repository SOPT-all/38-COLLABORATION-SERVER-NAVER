package com.sopt.collaboration.domain.home.controller;

import com.sopt.collaboration.domain.home.service.HomeService;
import com.sopt.collaboration.global.response.ApiResponseBody;
import com.sopt.collaboration.global.response.SuccessCode;
import io.swagger.v3.oas.annotations.Operation;
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
            @RequestParam(required = false) String expand
    ) {
        return ResponseEntity.ok(ApiResponseBody.ok(SuccessCode.OK, homeService.getCategories(expand)));
    }
}
