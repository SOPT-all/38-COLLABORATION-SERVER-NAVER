package com.sopt.collaboration.domain.home.exception;

import com.sopt.collaboration.global.exception.BusinessException;

public class HomeException extends BusinessException {

    public HomeException(HomeErrorCode errorCode) {
        super(errorCode);
    }
}