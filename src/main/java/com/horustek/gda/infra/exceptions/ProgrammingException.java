package com.horustek.gda.infra.exceptions;

public class ProgrammingException extends RuntimeException {

    public ProgrammingException(String message) {
        super(message);
    }

    public ProgrammingException(Throwable cause) {
        super(cause);
    }
}

