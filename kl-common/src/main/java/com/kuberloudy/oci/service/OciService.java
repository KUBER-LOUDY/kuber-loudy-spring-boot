package com.kuberloudy.oci.service;

import com.kuberloudy.oci.config.OciConfig;
import com.oracle.bmc.objectstorage.requests.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@RequiredArgsConstructor
@Service
public class OciService {

    String namespaceName = "idcsaij6dkcy";
    String bucketName = "kuberloudy-config";

    private final OciConfig configuration;

    public void upload(MultipartFile file) throws Exception {

        String objectName = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();


        //build upload request

        PutObjectRequest putObjectRequest =
                PutObjectRequest.builder()
                        .namespaceName(namespaceName)
                        .bucketName(bucketName)
                        .objectName(objectName)
                        .contentLength(file.getSize())
                        .putObjectBody(inputStream)
                        .build();

        try {
            configuration.getObjectStorage().putObject(putObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            configuration.getObjectStorage().close();
        }


    }
}