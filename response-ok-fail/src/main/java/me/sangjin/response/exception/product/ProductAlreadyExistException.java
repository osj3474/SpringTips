package me.sangjin.response.exception.product;

import me.sangjin.response.dto.common.ResponseCode;
import me.sangjin.response.exception.AbstractBaseException;

public class ProductAlreadyExistException extends AbstractBaseException {

    public ProductAlreadyExistException(ResponseCode responseCode) {
        super(responseCode);
    }
}
