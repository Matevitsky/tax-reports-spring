package com.matevytskyi.taxreports.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class);

    @GetMapping("/login")
    public String hello(Model model) {
        LOGGER.info("Started");

        return "ClientPage";
    }
}
