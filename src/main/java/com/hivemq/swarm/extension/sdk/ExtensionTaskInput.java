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

import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * @author Robin Atherton
 * @since 4.6.0
 */
public interface ExtensionTaskInput extends ExtensionInput {

    /**
     * Returns the client ID associated with the input.
     *
     * @return the client ID.
     * @since 4.6.0
     */
    @NotNull String getClientId();

    /**
     * Returns the additional arguments of the tag in the scenario.xml.
     *
     * @return the additional arguments.
     * @since 4.6.0
     */
    @NotNull Map<String, String> getAdditionalAttributes();
}
