package com.kuberloudy.awssdk.iam.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.iam.model.ListUsersResponse;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/aws",produces = "application/json; charset=utf8")
@RestController
public class AWSController {

    private final IamClient iam;

    @GetMapping("/iamusers")
    public void IamUserList(){
        ListUsersResponse userlist =iam.listUsers();
        log.info(userlist.users().get(1).userName());
    }

}
