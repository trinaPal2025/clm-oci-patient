package com.multiplan.clm_oci_patient.controller;

import com.multiplan.clm_oci_patient.dto.PatientDetailsRequestDTO;
import com.multiplan.clm_oci_patient.dto.PatientDetailsResponseDTO;
import com.multiplan.clm_oci_patient.service.PatientDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patientDetails")
@Api(tags = "PatientDetails Management")
public class PatientDetailsController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PatientDetailsService patientDetailsService;

    @ApiOperation(value = "Create Patient Details")
    @ApiResponses(value = {@ApiResponse(code = 201, response = PatientDetailsResponseDTO.class, message = "Patient Details successfully created"),
            @ApiResponse(code = 404, response = PatientDetailsResponseDTO.class, message = "Error Occurred While Creating Patient Details")})
    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public PatientDetailsResponseDTO createPatientDetails(@RequestBody PatientDetailsRequestDTO patientDetailsRequestDTO) {
        log.trace("Calling Patient Details service for input:{}", patientDetailsRequestDTO);
        return patientDetailsService.createPatientDetails(patientDetailsRequestDTO);
    }
}
