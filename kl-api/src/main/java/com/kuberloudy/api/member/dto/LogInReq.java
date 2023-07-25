package com.kuberloudy.api.member.dto;

import lombok.Getter;

@Getter
public class LogInReq {
    private String email;
    private String password;
}
