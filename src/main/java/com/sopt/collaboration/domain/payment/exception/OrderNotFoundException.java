package com.sopt.collaboration.domain.payment.exception;

import com.sopt.collaboration.global.exception.BusinessException;

public class OrderNotFoundException extends BusinessException {

    public OrderNotFoundException() {
        super(PaymentErrorCode.ORDER_NOT_FOUND);
    }
}