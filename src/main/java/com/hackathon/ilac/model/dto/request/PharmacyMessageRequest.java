package com.hackathon.ilac.model.dto.request;

import lombok.Data;

@Data
public class PharmacyMessageRequest {
    private Long userId;
    private String message;
}
