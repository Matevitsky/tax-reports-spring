package com.matevytskyi.taxreports.controller;

import com.matevytskyi.taxreports.config.security.jwt.JwtTokenProvider;
import com.matevytskyi.taxreports.service.CustomUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController {

    private static final String USERNAME = "username";
    private static final String TOKEN = "token";
    private static final String INVALID_USERNAME_PASSWORD_SUPPLIED = "Invalid username/password supplied";
    private static final String NOT_FOUND = "not found";
    private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, CustomUserDetailsService customUserDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.customUserDetailsService = customUserDetailsService;
    }

    @GetMapping("/")
    public String loginPage() {
        return "loginPage";
    }

    @PostMapping("/login")
    public String login(Model model, HttpServletRequest request, @RequestParam(name = "email") String email,
                        @RequestParam(name = "password") String password) {
        LOGGER.info("Started");
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            String token = jwtTokenProvider.createToken(email, this.customUserDetailsService.findUserByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException(USERNAME + email + NOT_FOUND)).getRoles());
            request.getSession().setAttribute("Authorization", "Bearer " + token);
            //    model.addAttribute("token", token);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException(INVALID_USERNAME_PASSWORD_SUPPLIED);
        }
        return "ClientPage";
    }
}
