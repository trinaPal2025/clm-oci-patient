package com.multiplan.clm_oci_patient.repository;

import com.multiplan.clm_oci_patient.domain.PatientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientDetailsRepository extends JpaRepository<PatientDetails, UUID> {

}
