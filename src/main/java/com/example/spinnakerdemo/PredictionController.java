package com.example.spinnakerdemo;

import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Timed
public class PredictionController {

    private final TimeToPickUpPredictionService predictionService;

    public PredictionController(TimeToPickUpPredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @GetMapping("/predict")
    public TimeToPickUp howLongToPickUp() {
        log.info("predictionService called");
        int seconds = predictionService.predict();
        return new TimeToPickUp(seconds);
    }


    static class TimeToPickUp {
        private final int seconds;

        public TimeToPickUp(int seconds) {
            this.seconds = seconds;
        }

        public int getSeconds() {
            return seconds;
        }
    }
}
