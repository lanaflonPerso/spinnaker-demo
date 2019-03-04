package com.example.spinnakerdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class MainController {

    @Value("${version}")
    private String version;

    @RequestMapping ("/")
    public String home (Model model) {
        log.info("version = " + version);
        if (version.equals("1.0")){
            model.addAttribute("headingColour", "blue");
        }
        else {
            model.addAttribute("headingColour", "green");
        }
        return "main";
    }
}
