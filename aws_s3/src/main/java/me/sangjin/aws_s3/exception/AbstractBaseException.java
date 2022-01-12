package me.sangjin.aws_s3.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.sangjin.aws_s3.dto.common.ResponseCode;

@Getter
@RequiredArgsConstructor
public abstract class AbstractBaseException extends RuntimeException{

    private final ResponseCode responseCode;

}
