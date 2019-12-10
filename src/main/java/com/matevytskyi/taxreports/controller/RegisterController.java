package com.matevytskyi.taxreports.controller;

import com.matevytskyi.taxreports.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    private ClientService clientService;

    @Autowired
    public RegisterController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/register")
    public String Register(@RequestParam(value = "firstName") String firstName) {
        // Client.builder().
        //client.setFirstName(firstName);
        //clientService.register(client);
        return "ClientPage";
    }
}
