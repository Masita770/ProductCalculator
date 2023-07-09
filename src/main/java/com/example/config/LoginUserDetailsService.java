package com.example.config;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class LoginUserDetailsService implements UserDetailsService {

    @Autowired
    UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return mapper.selectName(username);
        Optional<User> userData = mapper.selectName(username);
        return new LoginUserDetails(userData);
//        return userOp.map(user -> new LoginUserDetails(Optional.of(user));
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = mapper
//                .selectName(username)
//                .orElseThrow(() -> new UsernameNotFoundException("ユーザーが見つかりません"));
//
//        Collection<GrantedAuthority> authority =
//                Arrays.stream(user.getUsername().split(","))
//                        .map((role) -> new SimpleGrantedAuthority(role))
//                        .collect(Collectors.toList());
//
//        return new User(
//                user.getUsername(),
//                user.getPassword(),
//                authority
//        );


//    @Autowired
//    PasswordEncoder passwordEncoder;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> userOp = mapper.selectName(username);
//        return userOp.map(user -> new LoginUserDetails(Optional.of(user)))
//                .orElseThrow(() -> new UsernameNotFoundException("not found excception"));
//    }

//    @Transactional
//    public void register(String username, String password) {
//        U
//    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user = mapper.selectName(username);
//        if (user.isEmpty()) {
//            throw new UsernameNotFoundException("user not found");
//        }
////        // 6/28 機能について理解が足りていない
//        return new LoginUserDetails(user);
//////        return new LoginUserDetails(user.);
////        }
    }
