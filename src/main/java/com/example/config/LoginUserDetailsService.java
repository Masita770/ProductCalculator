package com.example.config;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
@Transactional
public class LoginUserDetailsService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    public LoginUserDetailsService(UserMapper mapper) {
        this.userMapper = mapper;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        return mapper.selectName(username);
//        Optional<User> userData = userMapper.selectName(username);
//        return new LoginUserDetails(userData);
////        return userOp.map(user -> new LoginUserDetails(Optional.of(user));
//    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return mapper.selectName(username);
       User userData = userMapper.selectName(username);
       return new LoginUserDetails(userData);
//        return userData.map(user -> new LoginUserDetails(Optional.of(user)))
//                .orElseThrow(() -> new UsernameNotFoundException(""));
//        return new LoginUserDetails(userData);
//        return userOp.map(user -> new LoginUserDetails(Optional.of(user));
    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userMapper.selectName(username);
////        if(user == null) {
////            throw new UsernameNotFoundException("Not Found");
////        }
//        return new LoginUserDetails(user);
//    }
//        try {
//            Optional<User> userData = mapper.selectName(username);
//            return new User(userData.get().getId(), PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(username.get), )
//        return mapper.selectName(username);
//        Optional<User> userData = mapper.selectOne(String.valueOf(String.valueOf(username)));
//        if (userData == null) {
//            throw new UsernameNotFoundException("Not found");
//            } catch (Exception e) {
//            throw new UsernameNotFoundException("ユーザーがありません");
//        }
//        Optional<User> userData = mapper.selectName(username, password);
////        return new User(userData.getUsername(), userData.getPassword(), Collections.emptyList().toString());
//        return new LoginUserDetails(userData);
//        if(!userData.ifPresent()) {
//            throw new UsernameNotFoundException(username);
//        }
//        return new LoginUserDetails(userData.get())
//        return new LoginUserDetails(userData);
//        return userData.map(LoginUserDetailsService::new)
//                .orElseThrow(() -> new UsernameNotFoundException("ユーザーを認識できません。"));
//        return userData;


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
//        }
    }
