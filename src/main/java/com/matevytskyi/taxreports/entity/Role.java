package com.matevytskyi.taxreports.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ADMIN,
    INSPECTOR;

    @Override
    public String getAuthority() {
        return name();
    }
}
