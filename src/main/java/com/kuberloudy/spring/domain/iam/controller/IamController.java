package com.kuberloudy.spring.domain.iam.controller;

import com.kuberloudy.spring.domain.iam.controller.dto.*;
import com.kuberloudy.spring.domain.iam.service.iamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.*;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/iam",produces = "application/json; charset=utf8")
public class IamController {
    private final iamService iamService;

    @PostMapping("/key-to-rsa")
    public ResponseEntity<?> KeyToRSA(@RequestBody IamUserTest iamUserTest) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        iamService.transitionIamUsertoRSA(iamUserTest);
        return new ResponseEntity<String>("reponse", HttpStatus.OK);
    }

    @GetMapping("/rsa-to-key")
    public void RSAtoKey(@RequestBody IamUserTest iamUserTest) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, IOException, BadPaddingException, InvalidKeyException {
        iamService.transitionRSAtoIam(iamUserTest);
    }

    @GetMapping("/iamusers")
    public void IamUserList(){


    }

}
