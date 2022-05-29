package com.hackathon.ilac.model.entity;

import com.hackathon.ilac.model.enums.Role;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "_pharmacy_token")
public class PharmacyToken {
    @Id
    private String token;
    @OneToOne
    private Pharmacy pharmacy;
}
