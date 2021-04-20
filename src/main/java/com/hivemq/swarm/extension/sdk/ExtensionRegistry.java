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
    void addSecurityProvider(final @NotNull String key, final @NotNull SecurityProvider securityProvider);

    /**
     * Register a {@link PayloadGenerator} with the specific key. It can be accessed in the scenario.xml with that key.
     *
     * @param key                    the key
     * @param payloadGenerator the {@link PayloadGenerator}
     */
    void addPayloadGenerator(final @NotNull String key, final @NotNull PayloadGenerator payloadGenerator);

    /**
     * Retrieve the {@link SecurityProvider} that is registered to that key. Returns null if no {@link SecurityProvider}
     * was registered to that key.
     *
     * @param key the Key
     * @return the {@link SecurityProvider} or null.
     */
    @Nullable SecurityProvider getSecurityProvider(final @NotNull String key);

    /**
     * Retrieve the {@link PayloadGenerator} that is registered to that key. Returns null if no {@link PayloadGenerator}
     * was registered to that key.
     *
     * @param key the Key
     * @return the {@link PayloadGenerator} or null.
     */
    @Nullable PayloadGenerator getPayloadGenerator(final @NotNull String key);

}
