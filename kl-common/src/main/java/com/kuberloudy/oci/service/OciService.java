package com.kuberloudy.oci.service;

import com.kuberloudy.oci.config.OciConfig;
import com.oracle.bmc.objectstorage.model.CreatePreauthenticatedRequestDetails;
import com.oracle.bmc.objectstorage.model.PreauthenticatedRequest;
import com.oracle.bmc.objectstorage.requests.CreatePreauthenticatedRequestRequest;
import com.oracle.bmc.objectstorage.requests.PutObjectRequest;
import com.oracle.bmc.objectstorage.responses.CreatePreauthenticatedRequestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OciService {
    private String namespaceName= "idcsaij6dkcy";
    private String bucketName = "kuberloudy-config";

    private final OciConfig configuration;

    public void upload(MultipartFile file) throws Exception {

        String objectName = "test"+"/"+ file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();

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

    public CreatePreauthenticatedRequestResponse getConfigFile() throws Exception{
        CreatePreauthenticatedRequestDetails createPreauthenticatedRequestDetails =
                CreatePreauthenticatedRequestDetails.builder()
                        .name("config")
                        .bucketListingAction(PreauthenticatedRequest.BucketListingAction.Deny)
                        .objectName("test"+"/"+"config")
                        .accessType(CreatePreauthenticatedRequestDetails.AccessType.ObjectRead)
                        .timeExpires(Date.from(Instant.now().plusSeconds(900))).build();

        CreatePreauthenticatedRequestRequest createPreauthenticatedRequestRequest =
                CreatePreauthenticatedRequestRequest.builder()
                        .namespaceName(namespaceName)
                        .bucketName(bucketName)
                        .createPreauthenticatedRequestDetails(createPreauthenticatedRequestDetails)
                        .opcClientRequestId(UUID.randomUUID().toString()).build();

        CreatePreauthenticatedRequestResponse response =
                configuration.getObjectStorage()
                        .createPreauthenticatedRequest(createPreauthenticatedRequestRequest);

        configuration.getObjectStorage().close();

        return response;
    }

}