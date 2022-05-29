package com.hackathon.ilac.model.entity;

import com.hackathon.ilac.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "_komek")
@SequenceGenerator(name = Komek.KOMEK_SEQ, sequenceName = Komek.KOMEK_SEQ, initialValue =202300,
        allocationSize =53)
public class Komek {

    public static final String  KOMEK_SEQ= "KOMEK_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = KOMEK_SEQ)
    private Long id;
    private String name;
    private String city;
    private double lat;
    private double lang;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role=Role.KBB;
}
