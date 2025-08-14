package com.multiplan.clm_oci_patient.dto;

import com.multiplan.clm_oci_patient.common.Gender;

import java.io.Serializable;
import java.util.UUID;

public class PatientDetailsResponseDTO implements Serializable {
    private UUID patientId;
    private String firstName;
    private String LastName;
    private String address;
    private String accountNumber;
    private Gender gender;

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
