package com.macalicestore.config;

import com.macalicestore.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    private final SuccessUserHandler successUserHandler;

    public WebSecurityConfig(SuccessUserHandler successUserHandler, UserService userService, PasswordEncoder passwordEncoder) {
        this.successUserHandler = successUserHandler;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                    .disable()
                .authorizeHttpRequests()
                    .requestMatchers("/**").permitAll()
//                    .antMatchers("/api/**").permitAll()
                    .requestMatchers("/admin").hasAuthority("ADMIN")
//                    .antMatchers("/user").hasAnyAuthority("USER", "ADMIN")
                    .anyRequest().authenticated();
//                .and()
//                    .formLogin()
//                    .loginPage("/")
//                    .loginProcessingUrl("/login")
//                    .successHandler(successUserHandler)
//                    .permitAll()
//                .and()
//                    .logout()
//                    .permitAll();

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.setUserDetailsService((UserDetailsService) userService);
        return authenticationProvider;
    }
}