package me.sangjin.aws_s3.handler;

import me.sangjin.aws_s3.dto.common.ErrorResponseDTO;
import me.sangjin.aws_s3.exception.AbstractBaseException;
import me.sangjin.aws_s3.exception.cloud_aws.S3InvalidFileTypeException;
import me.sangjin.aws_s3.exception.cloud_aws.S3UploadFailException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class S3ExceptionHandler {

    @ExceptionHandler(S3UploadFailException.class)
    public ErrorResponseDTO s3UploadFailExceptionHandle(HttpServletRequest req, AbstractBaseException e) {
        // 여기에 운영자들을 위한 로그를 남겨주세요~
        // [예시] log.error("request url={}", req.getRequestURL().toString());

        return ErrorResponseDTO.of(e.getResponseCode(), null);
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(S3InvalidFileTypeException.class)
    public ErrorResponseDTO s3InvalidFileExceptionHandle(HttpServletRequest req, AbstractBaseException e) {
        // 여기에 운영자들을 위한 로그를 남겨주세요~
        // [예시] log.error("request url={}", req.getRequestURL().toString());

        return ErrorResponseDTO.of(e.getResponseCode(), null);
    }
}
