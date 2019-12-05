package com.matevytskyi.taxreports;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @PostMapping("/app")
    public String hello(Model model, @RequestParam(value = "command") String command) {

        model.addAttribute("name", command);
        return "index";
    }
}
