package com.sopt.collaboration.domain.payment.controller;

import com.sopt.collaboration.domain.payment.dto.response.PointResponse;
import com.sopt.collaboration.domain.payment.service.PaymentService;
import com.sopt.collaboration.global.response.ApiResponseBody;
import com.sopt.collaboration.global.response.SuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Payment", description = "결제 조회 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class PaymentController {

    private final PaymentService paymentService;
    @Operation(summary = "포인트 조회 API")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "포인트 조회 성공"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "존재하지 않는 주문",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "success": false,
                                              "status": 404,
                                              "message": "존재하지 않는 주문입니다.",
                                              "code": "PAY_404_001",
                                              "meta": {
                                                "path": "/api/orders/1/points",
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
                                                "path": "/api/orders/1/points",
                                                "timestamp": 1746835200000
                                              }
                                            }
                                            """
                            )
                    )
            )
    })

    @GetMapping("/{orderId}/points")
    public ApiResponseBody<PointResponse, Void> getOrderPoints(
            @Parameter(
                    description = "주문 ID",
                    example = "101"
            )
            @PathVariable Long orderId
    ) {

        PointResponse response = paymentService.getOrderPoints(orderId);

        return ApiResponseBody.ok(
                SuccessCode.OK,
                response
        );
    }
}