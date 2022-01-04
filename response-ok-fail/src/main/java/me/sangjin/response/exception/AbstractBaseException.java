package me.sangjin.response.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.sangjin.response.dto.common.ResponseCode;

@Getter
@RequiredArgsConstructor
public abstract class AbstractBaseException extends RuntimeException{

    private final ResponseCode responseCode;

}
