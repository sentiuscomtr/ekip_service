package com.hackathon.ilac.model.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserLoginRequest {
    @NotNull
    @NotEmpty
    private String phone;
}
