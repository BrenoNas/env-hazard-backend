package com.breno.envhazardtracker.persistence.impl;
import com.breno.envhazardtracker.media.ports.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.core.sync.RequestBody;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.nio.ByteBuffer;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService {

    private final S3Client s3Client;

    @Value("${aws.bucket.name}")
    private String bucketName;

    @Override
    public String uploadFile(byte[] bytes, String fileName) {
        String filename = UUID.randomUUID() + "-" + fileName;
        try {
            PutObjectRequest putOb = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(filename)
                    .build();
            s3Client.putObject(putOb, RequestBody.fromByteBuffer(ByteBuffer.wrap(bytes)));
            GetUrlRequest request = GetUrlRequest.builder()
                    .bucket(bucketName)
                    .key(filename)
                    .build();
            return s3Client.utilities().getUrl(request).toString();
        } catch (Exception e) {
            log.error("failed to upload the file: {}", e.getMessage());
            return "";
        }
    }
}
