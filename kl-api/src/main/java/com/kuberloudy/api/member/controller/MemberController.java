package com.kuberloudy.api.member.controller;

import com.kuberloudy.api.member.repository.MemberRepository;
import com.kuberloudy.api.member.repository.PasswordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberRepository memberRepository;
    private final PasswordRepository passwordRepository;

}
