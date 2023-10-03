package com.example.config;

import com.example.domain.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
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
import org.thymeleaf.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;



@Service
@Transactional
public class LoginUserDetailsService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

//    @Autowired
//    public LoginUserDetailsService(UserMapper mapper) {
//        this.userMapper = mapper;
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userMapper.certificate(username);
//        return new LoginUserDetails(user);


   @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User userData = userMapper.certificate(username);
       if ( userData == null) {
           throw new UsernameNotFoundException("ユーザーが見つかりません");
       }
       return new LoginUserDetails(userData);


//        return new LoginUserDetails(user);
//        return new LoginUserDetails(user.get().getUsername(), user.get().getPassword(), Collections.emptyList().toString());
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = service.certificate(username);
//        return user;
//        return userMapper.certificate(username);
//    }
//    @Autowired
//    public LoginUserDetailsService(UserMapper mapper) {
//        this.userMapper = mapper;
//    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        return mapper.selectName(username);
//        Optional<User> userData = userMapper.selectName(username);
//        return new LoginUserDetails(userData);
////        return userOp.map(user -> new LoginUserDetails(Optional.of(user));
//    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//       Optional<User> user = userMapper.certificate(username);
//       if(!user.isPresent()) {
//           throw new UsernameNotFoundException("存在しない");
//       }
//       return new LoginUserDetails(String username);
//    }
}
