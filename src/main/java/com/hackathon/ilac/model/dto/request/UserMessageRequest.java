package com.hackathon.ilac.model.dto.request;

import lombok.Data;

@Data
public class UserMessageRequest {
    private Long pharmacyId;
    private String message;
}
