package com.sopt.collaboration.domain.product.exception;

import com.sopt.collaboration.global.exception.BusinessException;

public class ProductNotFoundException extends BusinessException {

    public ProductNotFoundException() {
        super(ProductErrorCode.PRODUCT_NOT_FOUND);
    }
}
