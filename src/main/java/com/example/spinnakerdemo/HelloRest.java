package com.example.spinnakerdemo;

import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Timed
public class HelloRest {

    @Value("${version}")
    private String version;

    @GetMapping ("/about")
    public String sayHi (){
        return "hello from spinnaker demo version [" + version + "]";
    }
}
