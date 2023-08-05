package com.kuberloudy.api.iam.controller;
import com.kuberloudy.api.iam.controller.dto.IamReq;
import com.kuberloudy.api.iam.controller.dto.IamRes;
import com.kuberloudy.api.iam.service.iamService;
import com.kuberloudy.api.iam.controller.dto.IamUserKey;
import com.kuberloudy.auth.AuthMember;
import com.kuberloudy.domain.iam.service.IamDomainService;
import com.kuberloudy.domain.member.entity.Member;
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
    private final IamDomainService iamDomainService;

    @PostMapping("/key-to-rsa")
    public ResponseEntity<?> KeyToRSA(@RequestBody IamUserKey iamUserKey) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidKeySpecException {
        iamService.transitionIamUsertoRSA(iamUserKey);
        return new ResponseEntity<String>("reponse", HttpStatus.OK);
    }

    @GetMapping("/rsa-to-key")
    public void RSAtoKey(@RequestBody IamUserKey iamUserKey) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, IOException, BadPaddingException, InvalidKeyException {
        iamService.transitionRSAtoIam(iamUserKey);
    }

    @GetMapping("/iamList")
    public ResponseEntity<?> IamList(@RequestParam Long memberId){
        return new ResponseEntity<>(iamDomainService.getIamlist(memberId), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<IamRes> IamCreate(@AuthMember Member member, @RequestBody IamReq req){
        IamRes res = iamService.createIam(member, req);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

}
