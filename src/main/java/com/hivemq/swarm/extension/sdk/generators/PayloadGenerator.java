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

package com.hivemq.swarm.extension.sdk.generators;

import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

/**
 * A payload generator is used to generate payloads for a Mqtt Publish.
 * <p>
 * It can be implemented to be scoped to any subset of its parameters.
 *
 * @author Simon Baier
 * @since 4.6.0
 */
public interface PayloadGenerator {

    /**
     * Generate the next payload for the generator. Parameters may be ignored by the implementation.
     *
     * @return payload as {@link ByteBuffer}
     * @since 4.6.0
     */
    @NotNull ByteBuffer nextPayload(@NotNull PayloadGeneratorInput payloadGeneratorInput);
}