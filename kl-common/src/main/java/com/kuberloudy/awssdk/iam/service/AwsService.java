package com.kuberloudy.awssdk.iam.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sso.SsoClient;
import software.amazon.awssdk.services.sso.model.ListAccountRolesRequest;
import software.amazon.awssdk.services.sso.model.ListAccountRolesResponse;

@Slf4j
@Service
@RequiredArgsConstructor
public class AwsService {

    private SsoClient ssoClient;

    //계정 자격 증 체크
  /* public ListAccountRolesRequest getAccountRoles(){


   }*/
}
