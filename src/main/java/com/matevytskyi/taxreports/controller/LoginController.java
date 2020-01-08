package com.matevytskyi.taxreports.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    private static final String USERNAME = "username";
    private static final String TOKEN = "token";
    private static final String INVALID_USERNAME_PASSWORD_SUPPLIED = "Invalid username/password supplied";
    private static final String NOT_FOUND = "not found";
    private static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);


    @GetMapping("/")
    public String loginPage() {
        return "loginPage";
    }

}
