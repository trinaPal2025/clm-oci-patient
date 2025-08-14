package com.multiplan.clm_oci_patient.Error;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Api Error Type")
public enum ApiErrorType {

    @Schema(description = "Business Error- check the ApiErrorResponse code value for additional information")
    API_ERROR,

    @Schema(description = "Authentication/Authorization Error")
    AUTHENTICATION_ERROR,

    @Schema(description = "Request was invalid")
    INVALID_REQUEST_ERROR,

    @Schema(description = "Unable to process the request due to internal errors")
    INTERNAL_ERROR
}
