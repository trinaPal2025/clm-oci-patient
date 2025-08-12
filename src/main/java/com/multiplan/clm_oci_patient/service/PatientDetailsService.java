package com.multiplan.clm_oci_patient.service;


import com.multiplan.clm_oci_patient.dto.PatientDetailsRequestDTO;
import com.multiplan.clm_oci_patient.dto.PatientDetailsResponseDTO;

public interface PatientDetailsService {

    public PatientDetailsResponseDTO createPatientDetails(PatientDetailsRequestDTO patientDetailsRequestDTOt);
}
