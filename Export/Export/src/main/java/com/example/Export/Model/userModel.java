package com.example.Export.Model;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name="user")
public class userModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String password;

    private String role = "ROLE_USER";

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singletonList(new SimpleGrantedAuthority(role));
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true; // Adjust if you have expiration logic
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true; // Adjust if you have lock logic
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true; // Adjust if you have expiration logic for credentials
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true; // Adjust if you have logic for enabling/disabling accounts
//    }
}
