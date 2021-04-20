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
