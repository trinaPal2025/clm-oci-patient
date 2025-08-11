package com.multiplan.clm_oci_patient.util;

import com.oracle.bmc.objectstorage.ObjectStorageClient;
import com.oracle.bmc.objectstorage.requests.GetObjectRequest;
import com.oracle.bmc.objectstorage.responses.GetObjectResponse;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PatientDBWalletDetails {

    private final ObjectStorageClient objectStorageClient;

    //identifier for object storage
    private final String nameSpace;

    public PatientDBWalletDetails(ObjectStorageClient objectStorageClient, String nameSpace) {
        this.objectStorageClient = objectStorageClient;
        this.nameSpace = nameSpace;
    }

    public void downLoadAndExtract(String bucketName, String objectName, String target) throws IOException {
        GetObjectResponse response = objectStorageClient.getObject(GetObjectRequest.builder().bucketName(bucketName).
                namespaceName(nameSpace).objectName(objectName).build());

        try(InputStream inputStream = response.getInputStream()){
            Path path= Paths.get(target, "Wallet_Pocclaimsdb.zip");
            Files.createDirectories(Paths.get(target));
            Files.copy(inputStream,path, StandardCopyOption.REPLACE_EXISTING);
            unzip(path.toString(),target);
            Files.delete(path);
        }
    }

    private void unzip(String path, String target) {


    }
}
