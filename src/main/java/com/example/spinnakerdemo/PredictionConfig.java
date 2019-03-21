package com.example.spinnakerdemo;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PredictionConfig {

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> metricsCommonTags
            (@Value("${DEPLOYMENT_TYPE:UNKNOWN}") String deploymentType) {
        return registry -> registry.config().commonTags("deployment", deploymentType);
    }

    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }

}
