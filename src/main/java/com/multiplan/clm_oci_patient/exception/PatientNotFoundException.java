package com.multiplan.clm_oci_patient.exception;

public class PatientNotFoundException extends RuntimeException
{
    public PatientNotFoundException(String message) {
        super(message);
    }
}
