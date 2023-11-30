package com.example.config;


import com.example.domain.Users;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginUserDetailsService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;



   @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Users userData = userMapper.certificate(Integer.valueOf(username));
       if ( userData == null) {
           throw new UsernameNotFoundException("ユーザーが見つかりません");
       }
       return new LoginUserDetails(userData);
    }
}
