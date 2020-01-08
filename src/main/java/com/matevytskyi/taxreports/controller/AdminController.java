package com.matevytskyi.taxreports.controller;

import com.matevytskyi.taxreports.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @RequestMapping("/adminPage")
    public ModelAndView getClientPage(Authentication authentication) {
        LOGGER.info("getAdminPage controller started");

        ModelAndView modelAndView = new ModelAndView("ClientPage");
        User user = (User) authentication.getPrincipal();
        //  List<Report> reportsByClientId = reportService.getReportsByClientId(user.getId());
        // modelAndView.addObject("reports",reportsByClientId);

        return modelAndView;
    }
}
