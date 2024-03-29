package com.kuberloudy.api.iam.controller.dto;

import com.kuberloudy.domain.iam.entity.Iam;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IamRes {

    private Long id;
    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime lastAccessDate;

    public IamRes(Iam iam) {
        this.id = iam.getIamId();
        this.name = iam.getName();
        this.createdDate = iam.getPermissionDate();
        this.lastAccessDate = iam.getLastAccessDate();
    }
}
