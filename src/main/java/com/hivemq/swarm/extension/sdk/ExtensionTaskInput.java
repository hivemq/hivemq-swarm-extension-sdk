package com.hivemq.swarm.extension.sdk;

import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * @author Robin Atherton
 */
public interface ExtensionTaskInput extends ExtensionInput {

    /**
     * Returns the clientID associated with the input.
     *
     * @return Client ID
     */
    @NotNull String getClientId();

    /**
     * Returns the additional arguments of the connect in the scenario.xml.
     *
     * @return the additional arguments
     */
    @NotNull Map<String, String> getAdditionalAttributes();
}
