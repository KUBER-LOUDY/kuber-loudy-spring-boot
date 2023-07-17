package com.kuberloudy.api.member.dto;

import lombok.Getter;

@Getter
public class MemberReq {
    private String email;
    private String name;
    private String provider;
}
