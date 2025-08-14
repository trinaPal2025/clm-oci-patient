package com.multiplan.clm_oci_patient.controller;

import com.multiplan.clm_oci_patient.dto.PatientDetailsRequestDTO;
import com.multiplan.clm_oci_patient.dto.PatientDetailsResponseDTO;
import com.multiplan.clm_oci_patient.service.PatientDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patientDetails")
public class PatientDetailsController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PatientDetailsService patientDetailsService;

    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public PatientDetailsResponseDTO createPatientDetails(@RequestBody PatientDetailsRequestDTO patientDetailsRequestDTO) {
        log.trace("Calling Patient Details service for input:{}", patientDetailsRequestDTO);
        return patientDetailsService.createPatientDetails(patientDetailsRequestDTO);
    }
}
