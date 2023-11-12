package com.example.config;

import com.example.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

//public class LoginUserDetails implements UserDetails {
//
//
//    public LoginUserDetails(User userData) {
//        this.userData = userData;
//    }
//
//    private User userData;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//
//    @Override
//    public String getPassword() {
//        return this.userData.getPassword();
//    }
//
//
//
//    @Override
//    public String getUsername() {
//        return this.userData.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}