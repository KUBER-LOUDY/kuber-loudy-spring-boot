package com.kuberloudy.awssdk.iam.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.sso.SsoClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class AwsService {

    private final SsoClient ssoClient;
    private final IamClient iamClient;

    public void getssoClient(){
        log.info(ssoClient.serviceName());
    }
    public void IamUserList(){
        String name = iamClient.listUsers().users().get(0).toString();
        log.info(name);
    }

}
