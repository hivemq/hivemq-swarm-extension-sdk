package com.hivemq.swarm.extension.sdk;

import com.codahale.metrics.MetricRegistry;
import com.hivemq.swarm.extension.sdk.generators.PayloadGenerator;
import com.hivemq.swarm.extension.sdk.security.SecurityProvider;
import org.jetbrains.annotations.NotNull;

/**
 * @author Yannick Weber
 */
public interface ExtensionContext extends ExtensionInput {

    /**
     * Use the {@link ExtensionRegistry} to register custom {@link PayloadGenerator} and
     * {@link SecurityProvider}
     *
     * @return the {@link ExtensionRegistry}
     */
    @NotNull ExtensionRegistry getExtensionRegistry();

    /**
     * Use the {@link MetricRegistry} to register extension-related metrics.
     *
     * @return the {@link MetricRegistry} of this hivemq-swarm instance.
     */
    @NotNull MetricRegistry getMetricRegistry();
}
