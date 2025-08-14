package com.multiplan.clm_oci_patient.config;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.nio.file.Path;

@Configuration
public class DataSourceConfig {

    @Autowired
    VaultSecretProperties vaultSecretProperties;

    @Autowired
    VaultService vaultService;

    @Autowired
    WalletDownloader walletDownloader;


    @Bean
    public DataSource dataSource() throws Exception {

        // Fetch secrets
        String walletJson = vaultService.getSecretValue(vaultSecretProperties.getWalletSecretOcid()); // wallet location OCID
        String username = vaultService.getSecretValue(vaultSecretProperties.getUsernameSecretOcid());
        String password = vaultService.getSecretValue(vaultSecretProperties.getPasswordSecretOcid());

        // Download wallet
        Path walletPath = walletDownloader.downloadWallet(walletJson, "axlo0xjafwdf");

        // Create DataSource
        OracleDataSource ods = new OracleDataSource();
        String walletpath =  walletPath.toRealPath().toString().replace("\\", "/");
        String url = "jdbc:oracle:thin:@pocclaimsdb_high?TNS_ADMIN="+walletpath;


        System.setProperty("oracle.net.tns_admin", walletpath);
        System.setProperty("javax.net.ssl.trustStore", walletpath+"\\cwallet.sso");
        System.setProperty("javax.net.ssl.trustStoreType", "SSO");
        ods.setURL(url);
        ods.setUser(username);
        ods.setPassword(password);
        ods.setDriverType("oracle.jdbc.OracleDriver");
        return ods;
    }
}