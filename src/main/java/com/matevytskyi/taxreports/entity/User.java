package com.matevytskyi.taxreports.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass

public abstract class User implements UserDetails {

    @Id
    @GeneratedValue
    private int id;

    @NotEmpty
    @NotNull
    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @NotNull
    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty
    @NotNull
    @NotBlank
    @Column(name = "email")
    private String email;

    @NotEmpty
    @NotNull
    @NotBlank
    @Column(name = "password")
    private String password;

    @NotNull
    @Builder.Default
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<UserRole> roles = new HashSet<>();

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
