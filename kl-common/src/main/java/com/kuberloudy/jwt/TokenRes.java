package com.kuberloudy.jwt;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class TokenRes {
    private String accessToken;
    private String refreshToken;
}
