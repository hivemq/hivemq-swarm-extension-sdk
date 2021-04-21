package com.hivemq.swarm.extension.sdk.security;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * @author Silvio Giebl
 */
public interface SecurityProviderOutput {

    /**
     * Configures username password authentication.
     *
     * @param username the username
     * @param password the password
     * @return this.
     */
    @NotNull SecurityProviderOutput userNamePassword(@NotNull String username, byte @Nullable [] password);

    /**
     * Sets the optional user defined {@link KeyManagerFactory}.
     *
     * @param keyManagerFactory the key manager factory or <code>null</code> to remove any previously set key manager
     *                          factory.
     * @return this.
     */
    @NotNull SecurityProviderOutput keyManagerFactory(@Nullable KeyManagerFactory keyManagerFactory);

    /**
     * Sets the optional user defined {@link TrustManagerFactory}.
     *
     * @param trustManagerFactory the trust manager factory or <code>null</code> to remove any previously set trust
     *                            manager factory
     * @return this.
     */
    @NotNull SecurityProviderOutput trustManagerFactory(@Nullable TrustManagerFactory trustManagerFactory);

    /**
     * Sets the optional user defined cipher suites.
     *
     * @param cipherSuites the cipher suites or <code>null</code> to use the default cipher suites of Netty (network
     *                     communication framework).
     * @return this.
     */
    @NotNull SecurityProviderOutput cipherSuites(@Nullable Collection<String> cipherSuites);

    /**
     * Sets the optional user defined protocols.
     *
     * @param protocols the protocols or <code>null</code> to use the default protocols of Netty (network communication
     *                  framework).
     * @return this.
     */
    @NotNull SecurityProviderOutput protocols(@Nullable Collection<String> protocols);

    /**
     * Sets the SSL/TLS handshake timeout}.
     * <p>
     * The timeout in nanoseconds must be in the range: [0, {@link Integer#MAX_VALUE}].
     *
     * @param handshakeTimeout the time unit of the given timeout (this timeout only supports millisecond precision).
     * @return this.
     */
    @NotNull SecurityProviderOutput handshakeTimeout(long handshakeTimeout, @NotNull TimeUnit timeUnit);

    /**
     * Sets the optional user defined hostname verifier.
     *
     * @param hostnameVerifier the hostname verifier or <code>null</code> to use https hostname verification.
     * @return this.
     */
    @NotNull SecurityProviderOutput hostnameVerifier(@Nullable HostnameVerifier hostnameVerifier);
}
