package com.kuberloudy.awssdk.iam.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.profiles.ProfileFile;
import software.amazon.awssdk.profiles.ProfileFileSupplier;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.iam.IamClient;
import software.amazon.awssdk.services.sso.SsoClient;

import java.nio.file.Path;

@Configuration
@RequiredArgsConstructor
public class AwsConfig {

   Path credentialsFilePath = Path.of("kl-common/src/main/resources/config");
   Region region = Region.AP_NORTHEAST_2;
   ProfileCredentialsProvider provider = ProfileCredentialsProvider
           .builder()
           .profileName("cliplse")
           .profileFile(ProfileFileSupplier.reloadWhenModified(credentialsFilePath, ProfileFile.Type.CONFIGURATION))
           .build();

   @Bean
   public SsoClient ssoClient(){
      return SsoClient.builder()
              .credentialsProvider(provider)
              .region(region)
              .build();
   }

   @Bean
    public IamClient iamClient(){
       return IamClient.builder()
               .credentialsProvider(provider)
               .region(region)
               .build();
   }
}
