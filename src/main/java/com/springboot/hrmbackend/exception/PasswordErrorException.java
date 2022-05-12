package com.springboot.hrmbackend.exception;

import org.hibernate.service.spi.ServiceException;

public class PasswordErrorException extends ServiceException {
    public PasswordErrorException(String message) {
        super(message);
    }
}
