package com.sopt.collaboration.domain.product.exception;

import com.sopt.collaboration.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductErrorCode implements ErrorCode {

    PRODUCT_NOT_FOUND(404, "PRD_404_001", "존재하지 않는 상품입니다.");

    private final int status;
    private final String code;
    private final String message;
}