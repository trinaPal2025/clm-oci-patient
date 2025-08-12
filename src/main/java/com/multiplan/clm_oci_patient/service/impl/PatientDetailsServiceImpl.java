package com.multiplan.clm_oci_patient.service.impl;

import com.multiplan.clm_oci_patient.domain.PatientDetails;
import com.multiplan.clm_oci_patient.dto.PatientDetailsRequestDTO;
import com.multiplan.clm_oci_patient.dto.PatientDetailsResponseDTO;
import com.multiplan.clm_oci_patient.repository.PatientDetailsRepository;
import com.multiplan.clm_oci_patient.service.PatientDetailsService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientDetailsServiceImpl implements PatientDetailsService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PatientDetailsRepository patientDetailsRepository;

    @Override
    public PatientDetailsResponseDTO createPatientDetails(PatientDetailsRequestDTO patientDetailsRequestDTO) {
        PatientDetailsResponseDTO response = null;
        try {
            log.info("converting patientDetailsRequestDTO to domain object");
            PatientDetails patientDetails = modelMapper.map(patientDetailsRequestDTO, PatientDetails.class);
            patientDetailsRepository.save(patientDetails);
            log.info("successfully saved patientDetails");
            response =   modelMapper.map(patientDetails, PatientDetailsResponseDTO.class);
            return response;
        } catch (Exception e) {
            log.error("error occurred while saving patientDetails");
        }
        return response;
    }
}
