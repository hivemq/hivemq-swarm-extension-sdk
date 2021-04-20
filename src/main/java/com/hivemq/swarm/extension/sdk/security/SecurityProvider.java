package com.hivemq.swarm.extension.sdk.security;

import org.jetbrains.annotations.NotNull;

/**
 * @author Yannick Weber
 */
public interface SecurityProvider {

    /**
     * This gets called for every connect with this security provider.
     * Use {@link Security.Builder} to create the returned object.
     *
     * @param input the {@link SecurityProviderInput}
     * @return the {@link Security}
     */
    @NotNull Security provideSecurity(@NotNull SecurityProviderInput input);

}
