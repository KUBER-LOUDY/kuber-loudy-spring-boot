package com.kuberloudy.domain.member.service;

import com.kuberloudy.domain.member.entity.Member;
import com.kuberloudy.domain.member.entity.Provider;
import com.kuberloudy.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberDomainService {
    private final MemberRepository memberRepository;

    public Member createMember(
            String email,
            String name,
            @Nullable String password,
            Provider provider
    ) {
        return memberRepository.save(
                Member.builder().email(email).name(name).provider(provider).build()
        );
    }

    public Member findMember(String email, String password) {
        return memberRepository.findByEmailAndPassword_Password(email, password)
                .orElseThrow(() -> new IllegalArgumentException("이메일 또는 비밀번호가 존재하지 않습니다."));
    }
}
