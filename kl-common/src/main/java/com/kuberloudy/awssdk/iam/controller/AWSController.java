package com.kuberloudy.awssdk.iam.controller;

import com.kuberloudy.awssdk.iam.service.AwsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(value = "/aws",produces = "application/json; charset=utf8")
@RestController
public class AWSController {

    private final AwsService awsService;
    //Iam 자격 확인
  /*  @GetMapping("/client")
    public ResponseEntity<SsoClient> SsoClient(){
        return new ResponseEntity<SsoClient>(awsService.getSsoClient(), HttpStatus.OK);
    }*/


}
