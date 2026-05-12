package com.sopt.collaboration.domain.payment.controller;

import com.sopt.collaboration.domain.payment.dto.response.PointResponse;
import com.sopt.collaboration.domain.payment.service.PaymentService;
import com.sopt.collaboration.global.response.ApiResponseBody;
import com.sopt.collaboration.global.response.SuccessCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class PaymentController {

    private final PaymentService paymentService;
    @Operation(summary = "포인트 조회 API")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "포인트 조회 성공"),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 주문"),
            @ApiResponse(responseCode = "500", description = "서버 내부 오류")
    })

    @GetMapping("/{orderId}/points")
    public ApiResponseBody<PointResponse, Void> getOrderPoints(
            @PathVariable Long orderId
    ) {

        PointResponse response = paymentService.getOrderPoints(orderId);

        return ApiResponseBody.ok(
                SuccessCode.OK,
                response
        );
    }
}