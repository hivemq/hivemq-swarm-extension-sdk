package com.hivemq.swarm.extension.sdk.generators;

import org.jetbrains.annotations.NotNull;

import java.nio.ByteBuffer;

/**
 * A payload generator is used to generate payloads for a Mqtt Publish.
 * <p>
 * It can be implemented to be scoped to any subset of its parameters.
 *
 * @author Simon Baier
 */
public interface PayloadGenerator {

    /**
     * Generate the next payload for the generator. Parameters may be ignored by the implementation.
     *
     * @return payload as {@link ByteBuffer}
     */
    @NotNull
    ByteBuffer nextPayload(@NotNull PayloadGeneratorInput payloadGeneratorInput);
}