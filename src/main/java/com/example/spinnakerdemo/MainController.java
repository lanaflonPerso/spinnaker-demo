package com.example.spinnakerdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;
import java.util.concurrent.TimeUnit;

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

    @GetMapping("/slowApi")
    public String timeConsumingAPI(@RequestParam(value = "delay", defaultValue = "0") Integer delay) throws InterruptedException {
        if(delay == 0) {
            Random random = new Random();
            delay = random.nextInt(10);
        }

        TimeUnit.SECONDS.sleep(delay);
        return "main";
    }
}
