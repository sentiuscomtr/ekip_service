package com.hackathon.ilac.error;


import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
public enum ErrorConstans {
    VALIDATION(BAD_REQUEST,"000"),
    EX_CONFIRM_TOKEN(BAD_REQUEST,"001"),
    WRONG_CONFIRM_TOKEN(BAD_REQUEST,"002"),
    WRONG_THIS_ID(BAD_REQUEST,"003"),
    WRONG_THIS_VALUE(BAD_REQUEST,"004"),
    EMPTY_VALUE(BAD_REQUEST,"004"),
    LIMITED_ACTION(BAD_REQUEST,"005"),
    REPETITIVE_ACTION(BAD_REQUEST,"006"),
    FILE_NAME(BAD_REQUEST,"007"),
    LOGIN(BAD_REQUEST,"008"),
    JWT(BAD_REQUEST,"009"),
    UNAUTHORIZD(UNAUTHORIZED,"010"),
    FORBIDDN(FORBIDDEN,"011"),
    SERVER(BAD_REQUEST,"012"),
    BAD_RQUEST(BAD_REQUEST,"013"),
    UPDATE_ERROR(BAD_REQUEST,"014"),
    FILE_EXCP(BAD_REQUEST,"015"),
    ADDED(BAD_REQUEST,"016"),
    USED_PHONE(BAD_REQUEST,"017"),
    FULL_NAME(BAD_REQUEST,"018"),
    USED_EMAIL(BAD_REQUEST,"019"),
    FULL_ADD_DONE(BAD_REQUEST,"020"),
    FULL_DUTY(BAD_REQUEST,"021"),
    EX_DONE_DUTY(BAD_REQUEST,"021"),
    INSUFFICIENT_BALANCE(BAD_REQUEST,"022"),
    WAIT_PAYMENT(BAD_REQUEST,"023"),
    NO_DATA(BAD_REQUEST,"024"),
    VERSION(BAD_REQUEST,"025"),
    ;
    private final HttpStatus httpStatus;
    private final String codes;
    ErrorConstans(HttpStatus status, String codes) {
        this.httpStatus = status;
        this.codes = codes;
    }
}