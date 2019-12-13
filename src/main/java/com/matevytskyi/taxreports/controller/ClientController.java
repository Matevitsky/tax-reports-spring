package com.matevytskyi.taxreports.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {
    private static final Logger LOGGER = Logger.getLogger(ClientController.class);

    @GetMapping("/create-report")
    public String Register(Model model) {
        LOGGER.info("Register controller started");
        return "ClientCreateReportPage";
    }
}
