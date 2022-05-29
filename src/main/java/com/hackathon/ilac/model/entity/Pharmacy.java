package com.hackathon.ilac.model.entity;

import com.hackathon.ilac.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "_pharmacy")
@SequenceGenerator(name = Pharmacy.Pharmacy_SEQ, sequenceName = Pharmacy.Pharmacy_SEQ, initialValue =12323423,
        allocationSize =53)
public class Pharmacy {
    public static final String  Pharmacy_SEQ= "Pharmacy_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Pharmacy_SEQ)
    private Long id;
    private String name;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role=Role.PHARMACY;
    private double lat;
    private double lang;
    private boolean dutyPharmacy;
}
