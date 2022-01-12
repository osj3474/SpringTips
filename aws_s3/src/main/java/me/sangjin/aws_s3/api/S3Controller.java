package me.sangjin.aws_s3.api;

import lombok.RequiredArgsConstructor;
import me.sangjin.aws_s3.dto.S3ResponseCode;
import me.sangjin.aws_s3.dto.S3ResponseDTO;
import me.sangjin.aws_s3.exception.cloud_aws.S3InvalidFileTypeException;
import me.sangjin.aws_s3.exception.cloud_aws.S3UploadFailException;
import me.sangjin.aws_s3.service.S3Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class S3Controller {

    private final S3Service s3Service;

    // S3에 업로드  ==>  파일 URI를 DTO에 담아서 반환
    @PostMapping("{dirName}")
    public S3ResponseDTO upload(
            @PathVariable String dirName,
            @RequestParam("images") MultipartFile multipartFile) {

        try {
            String imageLink = s3Service.upload(multipartFile, dirName);

            return S3ResponseDTO.builder()
                    .size(multipartFile.getSize())
                    .url(imageLink)
                    .build();

        } catch (S3InvalidFileTypeException e) {
            throw new S3InvalidFileTypeException(S3ResponseCode.AWS_S3_UPLOAD_FAIL_INVALID_TYPE);
        } catch (Exception e) {
            throw new S3UploadFailException(S3ResponseCode.AWS_S3_UPLOAD_FAIL);
        }
    }
}
