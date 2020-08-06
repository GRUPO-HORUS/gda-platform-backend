package com.horustek.gda.infra.exceptions;

import lombok.Data;

@SuppressWarnings({"serial"})

@Data
public class BusinessException extends RuntimeException {

    private Enum<?> errorCode;
    private Object[] messageParams;

    public BusinessException(Enum<?> errorCode, Object... messageParams) {
        super("");
        setErrorCode(errorCode);
        setMessageParams(messageParams);
    }
}
