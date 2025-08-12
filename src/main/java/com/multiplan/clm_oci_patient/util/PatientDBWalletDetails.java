package com.multiplan.clm_oci_patient.util;

import com.oracle.bmc.objectstorage.ObjectStorageClient;
import com.oracle.bmc.objectstorage.requests.GetObjectRequest;
import com.oracle.bmc.objectstorage.responses.GetObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Configuration
public class PatientDBWalletDetails {

    @Autowired
    ResourceLoader resourceLoader;
    private final ObjectStorageClient objectStorageClient;

    //identifier for object storage
    private final String nameSpace;

    public PatientDBWalletDetails(ObjectStorageClient objectStorageClient, String nameSpace) {
        this.objectStorageClient = objectStorageClient;
        this.nameSpace = nameSpace;
    }

    public void downLoadAndExtract(String bucketName, String objectName, String target) throws IOException {

    }

    private void unzip(String path, String target) {


    }
}
