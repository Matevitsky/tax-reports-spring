package com.matevytskyi.taxreports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String Register() {

        return "RegistrationPage";
    }
}
