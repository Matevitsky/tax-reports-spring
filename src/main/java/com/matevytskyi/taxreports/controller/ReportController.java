package com.matevytskyi.taxreports.controller;

import com.matevytskyi.taxreports.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/report")
public class ReportController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportController.class);

    private ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/")
    public String Register(@RequestParam(value = "firstName") String firstName) {
        // Client.builder().
        //client.setFirstName(firstName);
        //clientService.register(client);
        return "ClientPage";
    }

    @PostMapping("/save")
    public String save(@RequestParam(value = "tittle") String tittle, @RequestParam(value = "content") String content) {
        LOGGER.info("Save controller started");

        AbstractAuthenticationToken auth = (AbstractAuthenticationToken)
                SecurityContextHolder.getContext().getAuthentication();
        UserDetails details = (UserDetails) auth.getDetails();
        reportService.create(tittle, content);

        return "ClientCreateReportPage";
    }

}
