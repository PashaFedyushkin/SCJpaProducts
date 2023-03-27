package com.softclub.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class AbstractServiceException extends RuntimeException {
    private final HttpStatus httpStatus;
    public AbstractServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}

