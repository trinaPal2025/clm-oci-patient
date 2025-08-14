package com.multiplan.clm_oci_patient.dto;

import com.multiplan.clm_oci_patient.common.Gender;

import java.util.UUID;

public class PatientDetailsResponseDTO {
    private UUID patientId;
    private String firstName;
    private String LastName;
    private String address;
    private String accountNumber;
    private Gender gender;
    private Long relationShipCode;
}
