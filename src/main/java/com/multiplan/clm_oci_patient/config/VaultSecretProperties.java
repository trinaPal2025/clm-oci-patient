package com.multiplan.clm_oci_patient.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VaultSecretProperties {

    @Value("${oci.vault.wallet.secret.ocid}")
    private String walletSecretOcid;

    @Value("${oci.vault.username.secret.ocid}")
    private String usernameSecretOcid;

    @Value("${oci.vault.password.secret.ocid}")
    private String passwordSecretOcid;

    public String getWalletSecretOcid() {
        return walletSecretOcid;
    }

    public String getUsernameSecretOcid() {
        return usernameSecretOcid;
    }

    public String getPasswordSecretOcid() {
        return passwordSecretOcid;
    }
}
