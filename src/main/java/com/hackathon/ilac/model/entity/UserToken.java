package com.hackathon.ilac.model.entity;

import com.hackathon.ilac.model.enums.Role;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "_user_token")
public class UserToken {
    @Id
    private String token;
    @OneToOne
    private User user;
}
