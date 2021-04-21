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
import com.hivemq.swarm.extension.sdk.security.SecurityProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Yannick Weber
 */
public interface ExtensionRegistry {

    /**
     * Register a {@link SecurityProvider} with the specific key. It can be accessed in the scenario.xml with that key.
     *
     * @param key              the key
     * @param securityProvider the {@link SecurityProvider}
     */
    void addSecurityProvider(@NotNull String key, @NotNull SecurityProvider securityProvider);

    /**
     * Register a {@link PayloadGenerator} with the specific key. It can be accessed in the scenario.xml with that key.
     *
     * @param key                    the key
     * @param payloadGenerator the {@link PayloadGenerator}
     */
    void addPayloadGenerator(@NotNull String key, @NotNull PayloadGenerator payloadGenerator);

    /**
     * Retrieve the {@link SecurityProvider} that is registered to that key. Returns null if no {@link SecurityProvider}
     * was registered to that key.
     *
     * @param key the Key
     * @return the {@link SecurityProvider} or null.
     */
    @Nullable SecurityProvider getSecurityProvider(@NotNull String key);

    /**
     * Retrieve the {@link PayloadGenerator} that is registered to that key. Returns null if no {@link PayloadGenerator}
     * was registered to that key.
     *
     * @param key the Key
     * @return the {@link PayloadGenerator} or null.
     */
    @Nullable PayloadGenerator getPayloadGenerator(@NotNull String key);
}
