package com.mobile.domain.model.exceptions;

public class NoValidAuthorityException extends RuntimeException {
    public NoValidAuthorityException(String message) {
        super(message);
    }
}
