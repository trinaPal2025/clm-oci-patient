package com.multiplan.clm_oci_patient.config;

import com.oracle.bmc.auth.InstancePrincipalsAuthenticationDetailsProvider;
import com.oracle.bmc.secrets.SecretsClient;
import com.oracle.bmc.secrets.model.Base64SecretBundleContentDetails;
import com.oracle.bmc.secrets.requests.GetSecretBundleRequest;
import com.oracle.bmc.secrets.responses.GetSecretBundleResponse;

public class VaultService {
    private final SecretsClient secretsClient;

    public VaultService() {
        var provider = InstancePrincipalsAuthenticationDetailsProvider.builder().build();
        this.secretsClient = SecretsClient.builder().build(provider);
    }

    public String getSecretValue(String secretOcid) {
        GetSecretBundleResponse response = secretsClient.getSecretBundle(
                GetSecretBundleRequest.builder()
                        .secretId(secretOcid)
                        .stage(GetSecretBundleRequest.Stage.Current)
                        .build()
        );


        Base64SecretBundleContentDetails contentDetails =
                (Base64SecretBundleContentDetails) response.getSecretBundle().getSecretBundleContent();

        byte[] decodedBytes = java.util.Base64.getDecoder().decode(contentDetails.getContent());
        String secretValue = new String(decodedBytes, java.nio.charset.StandardCharsets.UTF_8);
        return secretValue;
    }
}