package com.hackathon.ilac.model.entity;

import com.hackathon.ilac.model.enums.Sender;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "_chatmessage")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @ManyToOne
    private Chat chat;
    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
    private Sender sender;
}
