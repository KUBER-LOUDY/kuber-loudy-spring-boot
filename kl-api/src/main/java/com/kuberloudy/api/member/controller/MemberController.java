package com.kuberloudy.api.member.controller;

import com.kuberloudy.api.member.dto.LogInReq;
import com.kuberloudy.api.member.dto.MemberReq;
import com.kuberloudy.api.member.dto.MemberRes;
import com.kuberloudy.api.member.service.MemberService;
import com.kuberloudy.jwt.TokenRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping()
    public ResponseEntity<MemberRes> signIn(@RequestBody MemberReq memberReq) {
        MemberRes response = memberService.signIn(memberReq);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenRes> logIn(@RequestBody LogInReq LoginReq) {
        TokenRes response = memberService.logIn(LoginReq);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
