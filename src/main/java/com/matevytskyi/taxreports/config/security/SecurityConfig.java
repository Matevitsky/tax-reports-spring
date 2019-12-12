package com.matevytskyi.taxreports.config.security;

import com.matevytskyi.taxreports.config.security.jwt.JwtSecurityConfigurer;
import com.matevytskyi.taxreports.config.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String LOGIN = "/login";
    private static final String API_USER = "/api/user/**";


    private final UserService userService;
    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()

                .antMatchers(LOGIN).permitAll()
                // .antMatchers(API_USER).hasAuthority(Role.SUPER_ADMIN.getAuthority())
                .anyRequest().authenticated()
                .and()
                .apply(new JwtSecurityConfigurer(jwtTokenProvider));
    }

    @Bean
    PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(getPasswordEncoder());
    }
}
