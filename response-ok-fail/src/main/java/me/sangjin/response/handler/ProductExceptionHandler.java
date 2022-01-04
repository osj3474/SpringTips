package me.sangjin.response.handler;

import me.sangjin.response.dto.common.ErrorResponseDTO;
import me.sangjin.response.exception.AbstractBaseException;
import me.sangjin.response.exception.product.ProductAlreadyExistException;
import me.sangjin.response.exception.product.ProductNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

// Controller, RestController 에서 발생하는 Exception 중에,
// @ExceptionHandler에 설정된 Exception은 여기서 처리.
// (서버 내부 에러 보여주면 안됨. DTO로 감싸기)
@RestControllerAdvice
public class ProductExceptionHandler {

    @ResponseStatus(BAD_REQUEST)  // 응답 값도 함께 표기
    @ExceptionHandler(ProductAlreadyExistException.class)  // ({Exception1.class, Exception2.class}) 로 여러개 설정 가능
    public ErrorResponseDTO badRequestExceptionHandle(HttpServletRequest req, AbstractBaseException e) {

        // 여기에 운영자들을 위한 로그를 남겨주세요~
        // [예시] log.error("request url={}", req.getRequestURL().toString());

        return ErrorResponseDTO.of(e.getResponseCode(), null);
    }

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponseDTO notFoundExceptionHandle(HttpServletRequest req, AbstractBaseException e) {

        // 여기에 운영자들을 위한 로그를 남겨주세요~
        // [예시] log.error("request url={}", req.getRequestURL().toString());

        return ErrorResponseDTO.of(e.getResponseCode(), null);
    }
}
