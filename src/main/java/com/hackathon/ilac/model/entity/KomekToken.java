package com.hackathon.ilac.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "_komektoken")
public class KomekToken {
    @Id
    private String token;
    @OneToOne
    private Komek komek;
}
