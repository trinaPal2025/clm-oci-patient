package com.multiplan.clm_oci_patient.dto;

import com.multiplan.clm_oci_patient.common.Gender;

import java.io.Serializable;

public class PatientDetailsRequestDTO implements Serializable {

    private String firstName;
    private String lastName;
    private String address;
    private String accountNumber;
    private Gender gender;
    private Long relationShipCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Long getRelationShipCode() {
        return relationShipCode;
    }

    public void setRelationShipCode(Long relationShipCode) {
        this.relationShipCode = relationShipCode;
    }
}
