package me.sangjin.response.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.sangjin.response.dto.common.ResponseCode;

@Getter
@RequiredArgsConstructor
public enum ProductResponseCode implements ResponseCode {
    PRODUCT_CREATE_OK(200, "상품 [생성]에 성공하였습니다."),
    PRODUCT_CREATE_FAIL_ALREADY_EXIST(400, "상품 [생성]에 실패하였습니다. - 이미 존재함"),

    PRODUCT_READ_OK(200, "상품 [조회]에 성공하였습니다."),
    PRODUCT_READ_FAIL(400, "상품 [조회]에 실패하였습니다."),

    PRODUCT_UPDATE_OK(200, "상품 [수정]에 성공하였습니다."),
    PRODUCT_UPDATE_FAIL_NOT_FOUND(400, "상품 [수정]에 실패하였습니다. - 해당 id 찾을 수 없음"),

    PRODUCT_DELETE_OK(200, "상품 [삭제]에 성공하였습니다."),
    PRODUCT_DELETE_FAIL_NOT_FOUND(400, "상품 [삭제]에 실패하였습니다. - 해당 id 찾을 수 없음");

    private final Integer statusCode;
    private final String message;
}
