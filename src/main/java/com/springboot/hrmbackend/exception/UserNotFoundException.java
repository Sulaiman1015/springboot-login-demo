package com.springboot.hrmbackend.exception;

import org.hibernate.service.spi.ServiceException;

public class UserNotFoundException extends ServiceException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
