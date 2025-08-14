package com.multiplan.clm_oci_patient.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Table(name = "PATIENTDETAILS")
@Entity
public class PatientDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PATIENT_ID")
    private Long patient_Id;

    @Column(name = "CITYNAME")
    private String cityName;

    @Column(name = "STATENAME")
    private String statemName;

    @Column(name = "PATIENTID")
    private UUID patientId;


    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String LastName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "ACCOUNTNUMBER")
    private String accountNumber;
    @Column(name = "GENDER")
    private String gender;

    @Column(name = "RELATIONSHIPCODE")

    private Long relationShipCode;

    @Column(name = "ADDRESSLINE1")
    private String addressline1;
}
