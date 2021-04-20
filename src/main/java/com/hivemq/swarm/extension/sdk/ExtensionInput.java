package com.hivemq.swarm.extension.sdk;

import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * This is the base interface for every extension input parameter.
 *
 * @author Yannick Weber
 * @since 2.0.0
 */
public interface ExtensionInput {

    /**
     * The location of the 'scenario-dependencies' directory.
     *
     * @return The 'scenario-dependencies‘ directory of HiveMQ Swarm.
     * @since 2.0.0
     */
    @NotNull File getScenarioDependencies();
}
