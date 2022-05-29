package com.hackathon.ilac.model.message;

import com.hackathon.ilac.model.enums.Sender;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SockMessage {
    private LocalDateTime date;
    private String message;
    private Sender sender;
}
