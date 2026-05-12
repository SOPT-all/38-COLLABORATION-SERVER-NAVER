package com.sopt.collaboration.domain.payment.exception;

import com.sopt.collaboration.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentErrorCode implements ErrorCode {

    ORDER_NOT_FOUND(404, "PAY_404_001", "존재하지 않는 주문입니다.");

    private final int status;
    private final String code;
    private final String message;
}