package me.sangjin.aws_s3.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import me.sangjin.aws_s3.dto.S3ResponseCode;
import me.sangjin.aws_s3.exception.cloud_aws.S3InvalidFileTypeException;
import me.sangjin.aws_s3.util.ImageType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class S3Service {

    @Value("${cloud.aws.s3.bucket}")
    public String bucket;

    private final AmazonS3Client amazonS3Client;

    // S3 파일 업로드 수행
    public String upload(MultipartFile multipartFile, String dirName) throws IOException {
        File uploadFile = convert(multipartFile)
                .orElseThrow(() -> new S3InvalidFileTypeException(S3ResponseCode.AWS_S3_UPLOAD_FAIL));

        return upload(uploadFile, dirName);
    }

    // S3로 파일 업로드
    private String upload(File uploadFile, String dirName) {
        // S3에 저장된 파일 이름
        final String fileName = dirName + "/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ssSS")) + "-" + uploadFile.getName();

        // s3로 업로드
        final String uploadImageUrl = putS3(uploadFile, fileName);

        // 로컬 파일 삭제
        removeLocalFile(uploadFile);

        return uploadImageUrl;
    }

    // S3로 업로드
    private String putS3(File uploadFile, String fileName) {

        amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, uploadFile).withCannedAcl(CannedAccessControlList.PublicRead));

        // 혹시 업로드 안된다면, S3권한 문제인지 아래로 확인.
//        try{
//            PutObjectRequest req = new PutObjectRequest(bucket, fileName, uploadFile).withCannedAcl(CannedAccessControlList.PublicRead);
//            amazonS3Client.putObject(req);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }

        return amazonS3Client.getUrl(bucket, fileName).toString();
    }

    // 로컬에 저장된 이미지 삭제
    private void removeLocalFile(File targetFile) {
        if (targetFile.delete()) {
            // 운영자들을 위해 여기에 로그를 남겨주세요~!
            // log.info("File delete success fileName={}", targetFile.getName());
            return;
        }

        // 운영자들을 위해 여기에 로그를 남겨주세요~!
        // log.info("File delete fail fileName={}", targetFile.getName());

    }

    // 로컬에 파일 업로드
    private Optional<File> convert(MultipartFile file) throws IOException {
        // 로컬 파일 저장
        final File convertFile = new File(
                System.getProperty("user.dir") + "/" + file.getOriginalFilename()
        );

        // 로컬 지정한 경로에 File 생성
        convertFile.createNewFile();

        // 업로드 가능한 파일 형식 검증
        if (! ImageType.isValidFileMimeType(convertFile, ImageType.IMAGE_MIME_TYPES)) {
            removeLocalFile(convertFile);
            throw new S3InvalidFileTypeException(S3ResponseCode.AWS_S3_UPLOAD_FAIL_INVALID_TYPE);
        }

        try (FileOutputStream fos = new FileOutputStream(convertFile)) {
            fos.write(file.getBytes());
        }

        return Optional.of(convertFile);
    }
}
