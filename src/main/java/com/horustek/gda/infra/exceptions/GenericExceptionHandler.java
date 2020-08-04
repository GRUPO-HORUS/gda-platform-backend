package com.horustek.gda.infra.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import org.springframework.http.HttpStatus;

@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @Autowired
    public GenericExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * Generic Exception Handler
     * @param ex the Exception
     * @return the ApiError object
     */
    @ExceptionHandler(Throwable.class)
    protected ResponseEntity<Object> Method(Throwable ex) {

        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
        String message = ex.getMessage() == null ? ex.toString() : ex.getMessage();

        if (ex instanceof BusinessException) {
            String errorCode = ((BusinessException) ex).getErrorCode().name();
            apiError.setErrorCode(errorCode);
            apiError.setStatus(HttpStatus.BAD_REQUEST.value());
            apiError.setError(HttpStatus.BAD_REQUEST);
            try {
                message = messageSource.getMessage(errorCode, ((BusinessException) ex).getMessageParams(), LocaleContextHolder.getLocale());
                apiError.setFormatted(message != null && !message.isEmpty());
            }
            catch (NoSuchMessageException mex) {
                message = mex.getMessage();
            }
        }
        apiError.setMessage(message);
        apiError.setDebugMessage(message);
        ex.printStackTrace();
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getError());
    }
}
