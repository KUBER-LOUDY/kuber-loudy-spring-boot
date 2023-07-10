package com.kuberloudy.spring.domain.iam.service;

import com.kuberloudy.spring.domain.iam.controller.dto.*;
import com.kuberloudy.spring.global.utils.rsaUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.*;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

@Service
@RequiredArgsConstructor
public class iamService {
    private final rsaUtil rsaUtil;

    @Transactional
    public ResponseEntity<?> transitionIamUsertoRSA(IamUserKey iamUserKey) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, IOException, BadPaddingException, InvalidKeyException {
        rsaUtil.encryptRSA(iamUserKey.getAccessKey());
        rsaUtil.encryptRSA(iamUserKey.getSecretKey());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<?> transitionRSAtoIam(IamUserKey iamUserKey) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, IOException, BadPaddingException, InvalidKeyException {
        rsaUtil.decryptRSA(iamUserKey.getAccessKey());
        rsaUtil.decryptRSA(iamUserKey.getSecretKey());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional
    public ResponseEntity<?> getIamUsers(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
