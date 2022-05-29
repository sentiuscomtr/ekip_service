package com.hackathon.ilac.model.dto.response;

import lombok.Data;

@Data
public class ChatResponse {
    private Long id;
    private Long userId;
    private String pharmacyName;
}
