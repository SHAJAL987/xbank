package com.userservice.module.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserAlreadyExistsException extends RuntimeException{
    private String resMessage;

    public UserAlreadyExistsException(String resMessage) {
        super(resMessage);
        this.resMessage = resMessage;
    }
}
