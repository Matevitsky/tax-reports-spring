package com.matevytskyi.taxreports.entity;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthorizedUser extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = 1L;
    private User user;

    public AuthorizedUser(User user) {
        super(user.getUsername(), user.getPassword(), user.isEnabled(), true, true,
                true, user.getRoles());
        this.user = user;
    }

    public static AuthorizedUser safeGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object principal = auth.getPrincipal();
        return (principal instanceof AuthorizedUser) ? (AuthorizedUser) principal : null;
    }
}
