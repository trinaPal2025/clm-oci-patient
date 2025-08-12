package com.multiplan.clm_oci_patient.config;

import com.oracle.bmc.auth.InstancePrincipalsAuthenticationDetailsProvider;
import com.oracle.bmc.objectstorage.ObjectStorageClient;
import com.oracle.bmc.objectstorage.requests.GetObjectRequest;
import com.oracle.bmc.objectstorage.responses.GetObjectResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.nio.file.*;
import java.util.zip.ZipInputStream;
import java.util.Map;

public class WalletDownloader {
    private final ObjectStorageClient objectStorageClient;

    public WalletDownloader() {
        var provider = InstancePrincipalsAuthenticationDetailsProvider.builder().build();
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

        Path walletDir = Files.createTempDirectory("C:/ClaimsPoc-Wallet");
        try (ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(zipBytes))) {
            var entry = zis.getNextEntry();
            while (entry != null) {
                Path filePath = walletDir.resolve(entry.getName());
                Files.copy(zis, filePath, StandardCopyOption.REPLACE_EXISTING);
                zis.closeEntry();
                entry = zis.getNextEntry();
            }
        }
        return walletDir;
    }
}

