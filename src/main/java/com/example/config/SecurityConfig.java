package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    UserDetailsService userDetailsService;
@Bean
PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}

    @Bean
    //protected void configure(HttpSecurity http) throws Exception {
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin(login -> login
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/user/list", true)
                .successForwardUrl("/user/list")
                .failureUrl("/login?error")
                .and()
        ).logout(logout -> logout.logoutSuccessUrl("/login?logout")
                .permitAll()
        ).authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/", "/login").permitAll()
                .anyRequest().authenticated()
        );
        return http.build();
    }
}
