package com.multiplan.clm_oci_patient.Error;

import io.swagger.v3.oas.annotations.media.Schema;

/*
 * Base Response for all Api Services to that error responses are consistent
 */
@Schema(description = "Api Error Response")
public class ApiErrorResponse implements ErrorResponse {

    @Schema(description = "Type of Api Error", required = true)
    private ApiErrorType type;

    @Schema(description = "Error code, will only be available for type API_ERROR")
    private String code;

    @Schema(description = "Error message")
    private String message;

    @Schema(description = "Exception stack trace- QA please do not include this field in tests as it's behavior is subject to change")
    private String trace;

    public ApiErrorType getType() {
        return type;
    }

    public void setType(ApiErrorType type) {
        this.type = type;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }
}
