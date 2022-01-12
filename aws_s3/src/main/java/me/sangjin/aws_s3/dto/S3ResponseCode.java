package me.sangjin.aws_s3.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.sangjin.aws_s3.dto.common.ResponseCode;

@Getter
@RequiredArgsConstructor
public enum S3ResponseCode implements ResponseCode {
    AWS_S3_UPLOAD_OK(200, "AWS S3 [업로드]에 성공하였습니다."),
    AWS_S3_UPLOAD_FAIL(400, "AWS S3 [업로드]에 실패하였습니다."),

    AWS_S3_UPLOAD_FAIL_INVALID_TYPE(400, "파일 형식이 올바르지 않습니다."),

    PRODUCT_READ_OK(200, "상품 [조회]에 성공하였습니다."),
    PRODUCT_READ_FAIL(400, "상품 [조회]에 실패하였습니다."),

    PRODUCT_UPDATE_OK(200, "상품 [수정]에 성공하였습니다."),
    PRODUCT_UPDATE_FAIL_NOT_FOUND(400, "상품 [수정]에 실패하였습니다. - 해당 id 찾을 수 없음"),

    PRODUCT_DELETE_OK(200, "상품 [삭제]에 성공하였습니다."),
    PRODUCT_DELETE_FAIL_NOT_FOUND(400, "상품 [삭제]에 실패하였습니다. - 해당 id 찾을 수 없음");

    private final Integer statusCode;
    private final String message;
}