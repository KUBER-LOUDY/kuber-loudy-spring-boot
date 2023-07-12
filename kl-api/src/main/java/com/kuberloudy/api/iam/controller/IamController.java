package com.kuberloudy.api.iam.controller;

import com.kuberloudy.api.iam.controller.dto.*;
import com.kuberloudy.api.iam.service.iamService;
import com.kuberloudy.api.iam.controller.dto.IamUserKey;
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
    public ResponseEntity<?> KeyToRSA(@RequestBody IamUserKey iamUserKey) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        iamService.transitionIamUsertoRSA(iamUserKey);
        return new ResponseEntity<String>("reponse", HttpStatus.OK);
    }

    @GetMapping("/rsa-to-key")
    public void RSAtoKey(@RequestBody IamUserKey iamUserKey) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, IOException, BadPaddingException, InvalidKeyException {
        iamService.transitionRSAtoIam(iamUserKey);
    }

    @GetMapping("/iamusers")
    public void IamUserList(){


    }

}