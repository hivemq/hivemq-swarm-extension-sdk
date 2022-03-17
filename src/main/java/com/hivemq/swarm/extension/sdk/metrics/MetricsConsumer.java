package com.hivemq.swarm.extension.sdk.metrics;

import org.jetbrains.annotations.NotNull;

public interface MetricsConsumer {
    void consumeMetricAfterScenario(@NotNull MetricsConsumerInput metricsConsumerInput);
}
