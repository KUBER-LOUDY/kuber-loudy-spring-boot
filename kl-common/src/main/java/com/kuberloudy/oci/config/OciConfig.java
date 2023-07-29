package com.kuberloudy.oci.config;

import com.oracle.bmc.ConfigFileReader;
import com.oracle.bmc.auth.ConfigFileAuthenticationDetailsProvider;
import com.oracle.bmc.objectstorage.ObjectStorage;
import com.oracle.bmc.objectstorage.ObjectStorageClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Path;

@RequiredArgsConstructor
@Configuration
public class OciConfig {

    String configurationFilePath = "kl-common/src/main/resources/ociConfig/config";
    String profileName = "DEFAULT";

    public ObjectStorage getObjectStorage() throws IOException {

        //load config file
        final ConfigFileReader.ConfigFile
                configFile = ConfigFileReader
                .parse(configurationFilePath, profileName);

        final ConfigFileAuthenticationDetailsProvider provider =
                new ConfigFileAuthenticationDetailsProvider(configFile);

        //build and return client
        return ObjectStorageClient.builder()
                .build(provider);
    }

}
