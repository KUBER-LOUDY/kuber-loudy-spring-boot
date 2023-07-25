package com.kuberloudy.api.member.dto;

import com.kuberloudy.domain.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberRes {
    private String name;
    private String message;

    public MemberRes(String memberName) {
        this.name = memberName;
        this.message = "성공적으로 회원가입 되셨습니다.";
    }
}
