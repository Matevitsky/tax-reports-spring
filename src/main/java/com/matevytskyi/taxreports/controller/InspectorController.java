package com.matevytskyi.taxreports.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/inspector")
public class InspectorController {

    private static Logger LOGGER = LoggerFactory.getLogger(InspectorController.class);

    @RequestMapping("/inspectorPage")
    public ModelAndView getClientPage(Authentication authentication) {
        LOGGER.info("getAdminPage controller started");
        ModelAndView modelAndView = new ModelAndView("inspector/InspectorPage");
        return modelAndView;
    }
}