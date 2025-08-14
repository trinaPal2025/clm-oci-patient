package com.multiplan.clm_oci_patient.config;

import com.multiplan.clm_oci_patient.Error.ApiErrorResponse;
import com.multiplan.clm_oci_patient.Error.ApiErrorType;
import com.multiplan.clm_oci_patient.Error.ApiExceptionHandler;
import com.multiplan.clm_oci_patient.exception.BusinessException;
import com.multiplan.clm_oci_patient.exception.InvalidRequestException;
import com.multiplan.clm_oci_patient.exception.ServiceUnavailableException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.NoSuchElementException;

/*
 * Setting Order to LOWEST_PRECEDENCE so service-specific ControllerAdvice can override
 * any of these ExceptionHandlers by setting Order to HIGHEST_PRECEDENCE.
 */
@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class DefaultApiExceptionHandler implements ApiExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public Logger getLogger() {
        return log;
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ApiErrorResponse handle(ResourceNotFoundException exception) {
        return handleApiException(exception, ApiErrorType.INVALID_REQUEST_ERROR);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ApiErrorResponse handle(NoSuchElementException exception) {
        return handleApiException(exception, ApiErrorType.INVALID_REQUEST_ERROR);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiErrorResponse handle(HttpMessageNotReadableException exception) {
        return handleApiException(exception, ApiErrorType.INVALID_REQUEST_ERROR);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiErrorResponse handle(InvalidRequestException exception) {
        return handleApiException(exception, ApiErrorType.INVALID_REQUEST_ERROR);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiErrorResponse handle(MethodArgumentNotValidException exception) {
        return handleApiException(exception, ApiErrorType.INVALID_REQUEST_ERROR);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiErrorResponse handle(DataIntegrityViolationException exception) {
        return handleApiException(exception, ApiErrorType.INVALID_REQUEST_ERROR);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiErrorResponse handle(ConstraintViolationException exception) {
        return handleApiException(exception, ApiErrorType.INVALID_REQUEST_ERROR);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ApiErrorResponse handle(SecurityException exception) {
        return handleApiException(exception, ApiErrorType.AUTHENTICATION_ERROR);
    }

    @ExceptionHandler
    public ApiErrorResponse handle(MethodArgumentTypeMismatchException exception, HttpServletResponse response) {
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return handleApiException(exception, ApiErrorType.INVALID_REQUEST_ERROR);
    }

    @ExceptionHandler
    public ApiErrorResponse handle(ConversionFailedException exception, HttpServletResponse response) {
        Exception rootCause = (Exception) ExceptionUtils.getRootCause(exception);

        if (rootCause instanceof ResourceNotFoundException) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return handleApiException(rootCause, ApiErrorType.INVALID_REQUEST_ERROR);
        }

        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return handleApiException(exception, ApiErrorType.INVALID_REQUEST_ERROR);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public ApiErrorResponse handle(BusinessException exception) {
        return handleApiException(exception, ApiErrorType.API_ERROR);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    public ApiErrorResponse handle(ServiceUnavailableException exception) {
        return handleApiException(exception, ApiErrorType.INTERNAL_ERROR);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse handle(Exception exception) {
        return handleApiException(exception, ApiErrorType.INTERNAL_ERROR);
    }
}
