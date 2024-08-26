package com.example.bookstoreapi.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class CustomMetrics {

    public CustomMetrics(MeterRegistry meterRegistry) {
        meterRegistry.gauge("custom.metric", 42);
    }
}
