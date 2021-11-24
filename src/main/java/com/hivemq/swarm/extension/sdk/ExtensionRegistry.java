/*
 * Copyright 2018-present HiveMQ GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hivemq.swarm.extension.sdk;

import com.hivemq.swarm.extension.sdk.generators.PayloadGenerator;
import com.hivemq.swarm.extension.sdk.metrics.MetricsConsumer;
import com.hivemq.swarm.extension.sdk.security.SecurityProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author Yannick Weber
 * @since 4.6.0
 */
public interface ExtensionRegistry {

    /**
     * Register a {@link SecurityProvider} with the specified key.
     * The {@link SecurityProvider} can then be accessed by the key in the scenario.xml.
     *
     * @param key              the key.
     * @param securityProvider the {@link SecurityProvider}.
     * @since 4.6.0
     */
    void addSecurityProvider(@NotNull String key, @NotNull SecurityProvider securityProvider);

    /**
     * Register a {@link PayloadGenerator} with the specified key.
     * The {@link PayloadGenerator} can then be accessed by the key in the scenario.xml.
     *
     * @param key              the key.
     * @param payloadGenerator the {@link PayloadGenerator}.
     * @since 4.6.0
     */
    void addPayloadGenerator(@NotNull String key, @NotNull PayloadGenerator payloadGenerator);

    /**
     * Retrieve the {@link SecurityProvider} that is registered to the specified key.
     * Returns <code>null</code> if no {@link SecurityProvider} was registered to that key.
     *
     * @param key the key.
     * @return the {@link SecurityProvider} or null.
     * @since 4.6.0
     */
    @Nullable SecurityProvider getSecurityProvider(@NotNull String key);

    /**
     * Retrieve the {@link PayloadGenerator} that is registered to the specified key.
     * Returns <code>null</code> if no {@link PayloadGenerator} was registered to that key.
     *
     * @param key the key.
     * @return the {@link PayloadGenerator} or null.
     * @since 4.6.0
     */
    @Nullable PayloadGenerator getPayloadGenerator(@NotNull String key);

    void addMetricsConsumer(@NotNull MetricsConsumer metricsConsumer);

    List<MetricsConsumer> getMetricsConsumers();
}
