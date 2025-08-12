package com.multiplan.clm_oci_patient.dto;

import com.multiplan.clm_oci_patient.common.Gender;
import com.multiplan.clm_oci_patient.common.RelationShipCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PatientDetails", description = "Create patient details")
public class PatientDetailsRequestDTO {

    @ApiModelProperty(value ="firstName", required = true)
    private String firstName;
    @ApiModelProperty(value ="lastName", required = true)
    private String LastName;
    @ApiModelProperty(value ="address", required = true)
    private String address;
    @ApiModelProperty(value ="accountNumber", required = true)
    private String accountNumber;
    @ApiModelProperty(value ="gender", required = true)
    private Gender gender;
    @ApiModelProperty(value ="relationShipCode", required = true)
    private RelationShipCode relationShipCode;
}
