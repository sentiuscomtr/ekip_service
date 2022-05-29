package com.hackathon.ilac.model.dto.response;

import com.hackathon.ilac.model.enums.Sender;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatMessageResponse {
    private String message;
    private LocalDateTime date;
    private Sender sender;
}
