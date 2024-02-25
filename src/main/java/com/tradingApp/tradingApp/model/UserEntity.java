package com.tradingApp.tradingApp.model;

import com.tradingApp.tradingApp.model.Enums.Role;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements UserDetails {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private double balance;
    @Nullable
    private String name;
    @Nullable
    private String surename;
    private Date createdDate;
    private double currentFeeFlat;
    private double currentFeePercentage;
    private int level;
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean isAccountExpired;
    private boolean isLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    private String perviouslyUsedPasswords;
    @OneToMany
    private List<Rating> ratingsRecived;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Report> reportsRecived;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Transaction> transactions;
    @OneToOne
    private Photo profilePicture;
    @OneToMany
    private List<TopUp> topUps;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }


    @Override
    public boolean isAccountNonExpired() {
        return isAccountExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }






}