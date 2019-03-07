package com.example.spinnakerdemo;

import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.logging.LoggingMeterRegistry;
import io.micrometer.core.instrument.logging.LoggingRegistryConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@SpringBootApplication
public class SpinnakerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpinnakerDemoApplication.class, args);
    }

}
