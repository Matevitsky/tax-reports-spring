package com.matevytskyi.taxreports.controller;


import com.matevytskyi.taxreports.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/client")
public class ClientController {
    private static Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/create-report")
    public String createReportPage(Model model) {
        LOGGER.info("createReportPage controller started");
        return "ClientCreateReportPage";
    }

    @RequestMapping("/clientPage")
    public String getClientPage() {
        LOGGER.info("getClientPage controller started");
        return "ClientPage";
    }

    @PostMapping("/create-client")
    public String createClient(@RequestParam(value = "firstName") String firstName,
                               @RequestParam(value = "lastName") String lastName,
                               @RequestParam(value = "emailAddress") String email,
                               @RequestParam(value = "password") String password,
                               @RequestParam(value = "companyName") String companyName) {
        clientService.create(firstName, lastName, email, password, companyName);
        return "clientPage";
    }
}
