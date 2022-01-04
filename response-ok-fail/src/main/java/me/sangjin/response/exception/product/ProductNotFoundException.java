package me.sangjin.response.exception.product;

import me.sangjin.response.dto.common.ResponseCode;
import me.sangjin.response.exception.AbstractBaseException;

public class ProductNotFoundException extends AbstractBaseException {

    public ProductNotFoundException(ResponseCode responseCode) {
        super(responseCode);
    }
}
