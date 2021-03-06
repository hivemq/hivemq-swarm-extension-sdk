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

package com.hivemq.swarm.extension.sdk.security;

import org.jetbrains.annotations.NotNull;

/**
 * @author Yannick Weber
 * @since 4.6.0
 */
public interface SecurityProvider {

    /**
     * This gets called for every connect with this security provider.
     *
     * @param input  the {@link SecurityProviderInput}.
     * @param output the {@link SecurityProviderOutput}.
     * @since 4.6.0
     */
    void onConnect(@NotNull SecurityProviderInput input, @NotNull SecurityProviderOutput output);
}
