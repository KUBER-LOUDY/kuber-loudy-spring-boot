package com.kuberloudy.api.iam.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.iam.IamClient;

@Configuration
@RequiredArgsConstructor
public class AwsConfig {
    Region region = Region.AP_NORTHEAST_2;

    @Bean
    public IamClient iamClient() {
        return IamClient.builder()
            .region(region)
            .credentialsProvider(ProfileCredentialsProvider.create())
            .build();
    }
}
