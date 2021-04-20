package com.hivemq.swarm.extension.sdk;

import org.jetbrains.annotations.NotNull;

/**
 * @author Yannick Weber
 */
public interface ExtensionMain {

    /**
     * This gets called when the extension is instantiated on an HiveMQ Swarm agent.
     *
     * @param extensionContext the {@link ExtensionContext}
     */
    void extensionMain(final @NotNull ExtensionContext extensionContext);

}
