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

import com.hivemq.swarm.extension.sdk.ExtensionTaskInput;
import org.jetbrains.annotations.NotNull;

/**
 * @author Yannick Weber
 */
public interface PayloadGeneratorInput extends ExtensionTaskInput {

    /**
     * The topic of the publish which the payload is generated for.
     *
     * @return the Topic.
     */
    @NotNull String getTopic();

    /**
     * The rate of publish messages of the publish command. This is given as the interval between publishes in
     * nanoseconds.
     *
     * @return the rate.
     */
    long getRate();

    /**
     * The count of publish messages of the publish command.
     *
     * @return the count.
     */
    long getCount();

    /**
     * The offset of the client within Range: [0..inf] of the client group this generator is associated with.
     *
     * @return Client offset
     */
    int getClientOffset();

}
