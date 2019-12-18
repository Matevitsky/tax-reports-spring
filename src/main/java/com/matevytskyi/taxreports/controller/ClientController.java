package com.matevytskyi.taxreports.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {
    private static Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @GetMapping("/create-report")
    public String createReportPAge(Model model) {
        LOGGER.info("Register controller started");
        return "ClientCreateReportPage";
    }
}
