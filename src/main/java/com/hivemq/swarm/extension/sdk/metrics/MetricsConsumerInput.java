package com.hivemq.swarm.extension.sdk.metrics;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public interface MetricsConsumerInput {
    @NotNull HashMap<String, Long> countersMap();
    @NotNull HashMap<String, HashMap<String, Long>> metersMap();
    @NotNull HashMap<String, String> timersMap();
    @NotNull ArrayList<Long> timerValues();
}
