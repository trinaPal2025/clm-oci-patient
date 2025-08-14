package com.multiplan.clm_oci_patient.controller;

import com.multiplan.clm_oci_patient.dto.PatientDetailsRequestDTO;
import com.multiplan.clm_oci_patient.dto.PatientDetailsResponseDTO;
import com.multiplan.clm_oci_patient.service.PatientDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patientDetails")
@Tag(name = "Patient Details", description = "operation related to patient details")
public class PatientDetailsController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PatientDetailsService patientDetailsService;

    @Operation(summary = "create patient details", description = "creates the new patient details")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "patient details created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})

    @PostMapping(path = "/create/patientDetails", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public PatientDetailsResponseDTO createPatientDetails(@RequestBody @Valid PatientDetailsRequestDTO patientDetailsRequestDTO) {
        log.trace("Calling Patient Details service for input:{}", patientDetailsRequestDTO);
        return patientDetailsService.createPatientDetails(patientDetailsRequestDTO);
    }
}
