package com.hackathon.ilac.auth;

import lombok.Data;

import javax.persistence.Id;

@Data
public class TokenResponse {
    private String token;
}
