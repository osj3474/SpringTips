package me.sangjin.aws_s3.dto.common;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponseDTO {

    Integer statusCode;
    String message;
    List<String> errors;

    public static ErrorResponseDTO of(ResponseCode responseCode, List<String> errors) {
        return ErrorResponseDTO.builder()
                .message(responseCode.getMessage())
                .statusCode(responseCode.getStatusCode())
                .errors(errors)
                .build();
    }

}
