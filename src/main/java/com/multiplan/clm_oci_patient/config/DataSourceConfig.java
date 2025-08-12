package com.multiplan.clm_oci_patient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.nio.file.Path;
import oracle.jdbc.pool.OracleDataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() throws Exception {
        VaultService vaultService = new VaultService();
        WalletDownloader walletDownloader = new WalletDownloader();

        // Fetch secrets
        String walletJson = vaultService.getSecretValue("ocid1.vaultsecret.oc1..wallet"); // wallet location OCID
        String username = vaultService.getSecretValue("ocid1.vaultsecret.oc1..username");
        String password = vaultService.getSecretValue("ocid1.vaultsecret.oc1..password");

        // Download wallet
        Path walletPath = walletDownloader.downloadWallet(walletJson, "C:/ClaimsPoc-Wallet");

        // Create DataSource
        OracleDataSource ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@myadb_tp?TNS_ADMIN=" + walletPath.toAbsolutePath());
        ods.setUser(username);
        ods.setPassword(password);
        return ods;
    }
}