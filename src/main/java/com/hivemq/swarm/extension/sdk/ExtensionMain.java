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

/**
 * @author Yannick Weber
 * @since 4.6.0
 */
public interface ExtensionMain {

    /**
     * This gets called when the extension is instantiated on an HiveMQ Swarm agent.
     *
     * @param extensionContext the {@link ExtensionContext}.
     * @since 4.6.0
     */
    void extensionMain(@NotNull ExtensionContext extensionContext);
}
