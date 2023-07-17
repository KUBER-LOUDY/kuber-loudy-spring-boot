package com.kuberloudy.api.member.service;

import com.kuberloudy.api.member.dto.MemberReq;
import com.kuberloudy.api.member.dto.MemberRes;
import com.kuberloudy.domain.member.entity.Member;
import com.kuberloudy.domain.member.entity.Provider;
import com.kuberloudy.domain.member.service.MemberDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberDomainService memberDomainService;

    public MemberRes signIn(MemberReq memberReq) {
        Member member = memberDomainService.createMember(
                memberReq.getEmail(),
                memberReq.getName(),
                "",
                Provider.valueOf(memberReq.getProvider())
        );
        return new MemberRes(memberReq.getName());
    }
}
