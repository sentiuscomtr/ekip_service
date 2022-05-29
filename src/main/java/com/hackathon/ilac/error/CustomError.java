package com.hackathon.ilac.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomError extends RuntimeException{
    private final HttpStatus status;

    public CustomError(String message,HttpStatus status) {
        super(message);
        this.status = status;
    }
    public CustomError(ErrorConstans errorConstans) {
        super(errorConstans.getCodes());
        this.status = errorConstans.getHttpStatus();
    }
}
