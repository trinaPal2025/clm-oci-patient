package com.multiplan.clm_oci_patient.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oracle.bmc.auth.ConfigFileAuthenticationDetailsProvider;
import com.oracle.bmc.objectstorage.ObjectStorageClient;
import com.oracle.bmc.objectstorage.requests.GetObjectRequest;
import com.oracle.bmc.objectstorage.responses.GetObjectResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.zip.ZipInputStream;

@Component
public class WalletDownloader {
    private final ObjectStorageClient objectStorageClient;

    public WalletDownloader() throws IOException {
        var provider =  new ConfigFileAuthenticationDetailsProvider("C:\\Users\\guruprasad.b\\.oci\\config",
                "DEFAULT");
        this.objectStorageClient = ObjectStorageClient.builder().build(provider);
    }

    public Path downloadWallet(String walletJson, String namespace) throws Exception {
        // Parse JSON { "bucket": "...", "object": "..." }
        Map<String, String> walletInfo = new ObjectMapper().readValue(walletJson, Map.class);

        GetObjectRequest request = GetObjectRequest.builder()
                .namespaceName(namespace)
                .bucketName(walletInfo.get("bucket"))
                .objectName(walletInfo.get("object"))
                .build();

        GetObjectResponse response = objectStorageClient.getObject(request);
        byte[] zipBytes = response.getInputStream().readAllBytes();

        Path walletDir = Files.createTempDirectory("ClaimsPocWallet");
        try (ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(zipBytes))) {
            var entry = zis.getNextEntry();
            while (entry != null) {
                Path filePath = walletDir.resolve(entry.getName());
                if (entry.isDirectory()) {
                    Files.createDirectories(filePath);
                } else {
                    Files.createDirectories(filePath.getParent());
                    Files.copy(zis, filePath, StandardCopyOption.REPLACE_EXISTING);
                }
                zis.closeEntry();
                entry = zis.getNextEntry();
            }
        }
        return walletDir;
    }
}

