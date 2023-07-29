package com.kuberloudy.awssdk.iam.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.sso.SsoClient;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/aws",produces = "application/json; charset=utf8")
@RestController
public class AWSController {

    private final SsoClient ssoClient;
    private final IamClient iamClient;

    //유저가 선택한 Iam profile에 따른 Client 빌딩
    @PostMapping("/iamClient")
    public void setIamClient(){
    }

    //Iam profile 클라우드 저장소에 저장

    // 저장한 Iam 리스트 반영
    @GetMapping("/iamusers")
    public String IamUserList(){
        String name = iamClient.listUsers().toString();
        return name;

    }

}
