package com.kuberloudy.api.member.service;

import com.kuberloudy.api.member.dto.LogInReq;
import com.kuberloudy.api.member.dto.MemberReq;
import com.kuberloudy.api.member.dto.MemberRes;
import com.kuberloudy.domain.member.entity.Member;
import com.kuberloudy.domain.member.entity.Provider;
import com.kuberloudy.domain.member.service.MemberDomainService;
import com.kuberloudy.jwt.JwtService;
import com.kuberloudy.jwt.TokenRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberDomainService memberDomainService;
    private final JwtService jwtService;

    public MemberRes signIn(MemberReq memberReq) {

        if (!memberReq.isValid()) {
            throw new IllegalArgumentException("사용자에 대한 올바른 정보를 입력해주세요.");
        }

        Member member = memberDomainService.createMember(
                memberReq.getEmail(),
                memberReq.getName(),
                memberReq.getPassword(),
                Provider.valueOf(memberReq.getProvider())
        );
        return new MemberRes(memberReq.getName());
    }

    public TokenRes logIn(LogInReq loginReq) {
        Member member = memberDomainService.findMember(
                loginReq.getEmail(),
                loginReq.getPassword());
        return jwtService.createJwt(
                member.getEmail(),
                member.getPassword()
        );
    }
}
