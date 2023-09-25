package com.example.config;

import com.example.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class LoginUserDetails implements UserDetails {

//    private String username;
//    private String password;
//    private List<GrantedAuthority> authorities = new ArrayList<>();
//
//    public LoginUserDetails(String username, String password, String authority) {
//        this.username = username;
//        this.password = password;
//        this.authorities = AuthorityUtils.createAuthorityList(authority);
//    }

//    public LoginUserDetails(User user) {
//        super();
//    }

    private User userData;
    public LoginUserDetails(User userData) {
        this.userData = userData;
    }

//    private User user;
//    public LoginUserDetails(User user) {
//        super();
//        this.user = user;
//    }
//
//    public User getUser() {
//        return user;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    @Override
    public String getPassword() {
        return this.userData.getPassword();
    }

    @Override
    public String getUsername() {
        return this.userData.getUsername();
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