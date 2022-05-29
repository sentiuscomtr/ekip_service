package com.hackathon.ilac.auth.details;

import com.hackathon.ilac.model.entity.Komek;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class KomekAuthDetails implements UserDetails {
    @Getter
    @Setter
    private Komek komek;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()  {
        return Arrays.asList(komek.getRole());
    }

    @Override
    public String getPassword() {
        return komek.getPassword();
    }

    @Override
    public String getUsername() {
        return Long.toString(komek.getId());
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
