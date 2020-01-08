package com.matevytskyi.taxreports.controller;


import com.matevytskyi.taxreports.entity.Report;
import com.matevytskyi.taxreports.entity.User;
import com.matevytskyi.taxreports.service.ClientService;
import com.matevytskyi.taxreports.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {
    private static Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    private ClientService clientService;
    private ReportService reportService;

    public ClientController(ClientService clientService, ReportService reportService) {
        this.clientService = clientService;
        this.reportService = reportService;
    }

    @GetMapping("/create-report")
    public String createReportPage(Model model) {
        LOGGER.info("createReportPage controller started");
        return "ClientCreateReportPage";
    }

    @RequestMapping("/clientPage")
    public ModelAndView getClientPage(Authentication authentication) {
        LOGGER.info("getClientPage controller started");

        ModelAndView modelAndView = new ModelAndView("ClientPage");
        User user = (User) authentication.getPrincipal();
        List<Report> reportsByClientId = reportService.getReportsByClientId(user.getId());
        modelAndView.addObject("reports", reportsByClientId);

        return modelAndView;
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
