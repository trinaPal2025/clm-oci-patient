package com.multiplan.clm_oci_patient.Error;


import com.multiplan.clm_oci_patient.exception.BusinessException;

public interface ApiExceptionHandler extends ApiExceptionLogger, ApiErrorResponseBuilder {

    default ApiErrorResponse handleApiException(BusinessException exception, ApiErrorType type) {
        logException(exception);
        return buildApiErrorResponse(exception, type);
    }

    default ApiErrorResponse handleApiException(Exception exception, ApiErrorType type) {
        logException(exception);
        return buildApiErrorResponse(exception, type);
    }

}
