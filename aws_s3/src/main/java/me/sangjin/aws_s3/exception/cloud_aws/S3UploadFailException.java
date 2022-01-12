package me.sangjin.aws_s3.exception.cloud_aws;

import me.sangjin.aws_s3.dto.common.ResponseCode;
import me.sangjin.aws_s3.exception.AbstractBaseException;

public class S3UploadFailException extends AbstractBaseException {

    public S3UploadFailException(ResponseCode responseCode) {
        super(responseCode);
    }
}
