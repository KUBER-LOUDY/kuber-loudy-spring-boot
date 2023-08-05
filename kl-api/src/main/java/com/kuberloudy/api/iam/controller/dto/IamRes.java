package com.kuberloudy.api.iam.controller.dto;

import com.kuberloudy.domain.iam.entity.Iam;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IamRes {
    private String message;
    private String name;

    public IamRes(Iam iam) {
        this.name = iam.getName();
        this.message = "IAM 유저 토큰을 성공적으로 저장했습니다.";
    }
}
