package com.multiplan.clm_oci_patient.domain;

import com.multiplan.clm_oci_patient.common.Gender;
import com.multiplan.clm_oci_patient.common.RelationShipCode;
import jakarta.persistence.*;

import java.util.UUID;

@Table(name="PATIENTDETAILS")
@Entity
public class PatientDetails {

    @Column(name = "PATIENTID")
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
    private Gender gender;

    @Column(name = "RELATIONSHIPCODE")

    private RelationShipCode relationShipCode;
}
