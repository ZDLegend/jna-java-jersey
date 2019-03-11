package com.zdl.code.exception;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String e) {
        super(e);
    }
}
