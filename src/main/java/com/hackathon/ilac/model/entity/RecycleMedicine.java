package com.hackathon.ilac.model.entity;

import com.hackathon.ilac.model.enums.RecycleType;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "_recycle")
public class RecycleMedicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Medicine medicine;
    @ManyToOne
    private Komek komek;
    private int number;
    @Enumerated(EnumType.STRING)
    private RecycleType type;
    private LocalDateTime skt;

}
