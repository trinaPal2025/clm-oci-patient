package com.multiplan.clm_oci_patient.Error;

import com.multiplan.clm_oci_patient.exception.BusinessException;
import org.apache.commons.lang3.exception.ExceptionUtils;


public interface ApiErrorResponseBuilder {

    default ApiErrorResponse buildApiErrorResponse(BusinessException exception, ApiErrorType type) {
        ApiErrorResponse apiError = new ApiErrorResponse();
        apiError.setType(type);
        apiError.setMessage(exception.getMessage());
        apiError.setCode(exception.getCode());
        return apiError;
    }

    default ApiErrorResponse buildApiErrorResponse(Exception exception, ApiErrorType type) {
        ApiErrorResponse apiError = new ApiErrorResponse();
        apiError.setType(type);
        apiError.setMessage(exception.getMessage());
        apiError.setTrace(ExceptionUtils.getStackTrace(exception));
        return apiError;
    }

}
