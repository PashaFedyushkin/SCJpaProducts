package com.softclub.exception;

import com.softclub.exception.AbstractServiceException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ProductException extends AbstractServiceException {
    private final HttpStatus httpStatus;
    public ProductException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
        this.httpStatus = httpStatus;
    }
}