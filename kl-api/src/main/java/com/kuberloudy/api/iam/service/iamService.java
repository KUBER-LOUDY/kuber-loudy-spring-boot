package com.kuberloudy.api.iam.service;

import com.kuberloudy.api.iam.controller.dto.IamReq;
import com.kuberloudy.api.iam.controller.dto.IamRes;
import com.kuberloudy.api.iam.utils.rsaUtil;
import com.kuberloudy.api.iam.controller.dto.IamUserKey;
import com.kuberloudy.domain.iam.entity.Iam;
import com.kuberloudy.domain.iam.service.IamDomainService;
import com.kuberloudy.domain.member.entity.Member;
import com.kuberloudy.domain.member.service.MemberDomainService;
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
    private final IamDomainService iamDomainService;

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

    public IamRes createIam(Member member, IamReq req) {
        Iam iam = iamDomainService.createIamUser(member, req.getName(), req.getAccessKey(), req.secretKey);
        return new IamRes(iam);
    }
}
