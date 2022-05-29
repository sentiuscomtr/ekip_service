package com.hackathon.ilac.model.enums;

import org.springframework.security.core.GrantedAuthority;



public enum Role implements GrantedAuthority {
    USER("USER"),
    PHARMACY("PHARMACY"),
    KBB("KBB"),
    ;
    private final String role;

    Role(String role) {
        this.role=role;
    }
    @Override
    public String getAuthority() {
        return name();
    }
}