package com.matevytskyi.taxreports.controller;


import com.matevytskyi.taxreports.dto.ReportWithClientName;
import com.matevytskyi.taxreports.entity.User;
import com.matevytskyi.taxreports.service.InspectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/inspector")
public class InspectorController {

    private static Logger LOGGER = LoggerFactory.getLogger(InspectorController.class);

    private InspectorService inspectorService;

    @Autowired
    public InspectorController(InspectorService inspectorService) {
        this.inspectorService = inspectorService;
    }

    @RequestMapping("/inspectorPage")
    public ModelAndView getClientPage(Authentication authentication) {
        LOGGER.info("getAdminPage controller started");
        ModelAndView modelAndView = new ModelAndView("inspector/InspectorPage");
        User user = (User) authentication.getPrincipal();
        List<ReportWithClientName> reportsByInspectorId = inspectorService.getNewReports(user.getId());
        modelAndView.addObject("reports", reportsByInspectorId);
        return modelAndView;
    }
}