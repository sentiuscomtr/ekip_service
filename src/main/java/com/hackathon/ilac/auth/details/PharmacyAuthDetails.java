package com.hackathon.ilac.auth.details;

import com.hackathon.ilac.model.entity.Pharmacy;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class PharmacyAuthDetails implements UserDetails {

    @Getter
    @Setter
    private Pharmacy pharmacy;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(pharmacy.getRole());
    }

    @Override
    public String getPassword() {
        return pharmacy.getPassword();
    }

    @Override
    public String getUsername() {
        return Long.toString(pharmacy.getId());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
