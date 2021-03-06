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

import com.codahale.metrics.MetricRegistry;
import com.hivemq.swarm.extension.sdk.generators.PayloadGenerator;
import com.hivemq.swarm.extension.sdk.security.SecurityProvider;
import org.jetbrains.annotations.NotNull;

/**
 * @author Yannick Weber
 * @since 4.6.0
 */
public interface ExtensionContext extends ExtensionInput {

    /**
     * Use the {@link ExtensionRegistry} to register custom {@link PayloadGenerator} and {@link SecurityProvider}.
     *
     * @return the {@link ExtensionRegistry}.
     * @since 4.6.0
     */
    @NotNull ExtensionRegistry getExtensionRegistry();

    /**
     * Use the {@link MetricRegistry} to register new or reuse extension-related metrics.
     *
     * @return the {@link MetricRegistry}.
     * @since 4.6.0
     */
    @NotNull MetricRegistry getMetricRegistry();
}
