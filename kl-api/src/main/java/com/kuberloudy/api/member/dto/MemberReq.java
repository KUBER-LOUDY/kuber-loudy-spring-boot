package com.kuberloudy.api.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.util.Objects;

@Getter
public class MemberReq {
    private String email;
    private String name;
    private String password;
    private String provider;

    public Boolean isOAuth2LogIn() {
        return !Objects.equals(this.provider, "KUBERLOUDY");
    }

    public Boolean isValid() {
        return !Objects.equals(this.email, null)
                && !Objects.equals(this.name, null)
                && !Objects.equals(this.provider, null);
    }
}
