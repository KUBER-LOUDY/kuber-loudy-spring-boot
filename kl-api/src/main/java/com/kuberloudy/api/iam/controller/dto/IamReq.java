package com.kuberloudy.api.iam.controller.dto;

import lombok.Getter;

@Getter
public class IamReq {
    public String name;
    public String accessKey;
    public String secretKey;
}
