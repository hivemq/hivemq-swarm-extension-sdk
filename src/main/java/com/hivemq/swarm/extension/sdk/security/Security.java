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
import org.jetbrains.annotations.Nullable;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * @author Robin Atherton
 * @author Yannick Weber
 */
public class Security {

    private static final long NO_HANDSHAKE_TIMEOUT = -1;

    /* Username Password */
    private final @Nullable String userName;

    private final byte @Nullable [] password;

    private final @Nullable KeyManagerFactory keyManagerFactory;
    private final @Nullable TrustManagerFactory trustManagerFactory;

    private final @Nullable Collection<String> cipherSuites;
    private final @Nullable Collection<String> protocols;

    private final long handshakeTimeout;

    private final @Nullable HostnameVerifier hostnameVerifier;
    private final @NotNull TimeUnit handshakeTimeUnit;

    private Security(
            final @Nullable String userName,
            final byte @Nullable [] password,
            final @Nullable KeyManagerFactory keyManagerFactory,
            final @Nullable TrustManagerFactory trustManagerFactory,
            final @Nullable Collection<String> cipherSuites,
            final @Nullable Collection<String> protocols,
            final long handshakeTimeout,
            final @NotNull TimeUnit handshakeTimeUnit,
            final @Nullable HostnameVerifier hostnameVerifier) {

        this.userName = userName;
        this.password = password;
        this.keyManagerFactory = keyManagerFactory;
        this.trustManagerFactory = trustManagerFactory;
        this.cipherSuites = cipherSuites;
        this.protocols = protocols;
        this.handshakeTimeout = handshakeTimeout;
        this.handshakeTimeUnit = handshakeTimeUnit;
        this.hostnameVerifier = hostnameVerifier;
    }

    public @Nullable String getUsername() {
        return userName;
    }

    public byte @Nullable [] getPassword() {
        return password;
    }

    public @Nullable Collection<String> getCipherSuites() {
        return cipherSuites;
    }

    public @Nullable Collection<String> getProtocols() {
        return protocols;
    }

    public @Nullable KeyManagerFactory getKeyManagerFactory() {
        return keyManagerFactory;
    }

    public @Nullable TrustManagerFactory getTrustManagerFactory() {
        return trustManagerFactory;
    }

    public long getHandshakeTimeout() {
        return handshakeTimeout;
    }

    public @NotNull TimeUnit getHandshakeTimeUnit() {
        return handshakeTimeUnit;
    }

    public @Nullable HostnameVerifier getHostnameVerifier() {
        return hostnameVerifier;
    }

    public static @NotNull Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private @Nullable String userName;
        private byte @Nullable [] password;
        private @Nullable KeyManagerFactory keyManagerFactory;
        private @Nullable TrustManagerFactory trustManagerFactory;
        private @Nullable Collection<String> cipherSuites;
        private @Nullable Collection<String> protocols;
        private long handshakeTimeout = NO_HANDSHAKE_TIMEOUT;
        private @Nullable HostnameVerifier hostnameVerifier;
        private @NotNull TimeUnit handshakeTimeUnit;

        /**
         * Configures username password authentication.
         *
         * @param username the username
         * @param password the password
         * @return the {@link Security}
         */
        public @NotNull Builder userNamePassword(
                final @NotNull String username, final byte @Nullable [] password) {
            this.userName = username;
            this.password = password;
            return this;
        }

        /**
         * Sets the optional user defined {@link KeyManagerFactory}.
         *
         * @param keyManagerFactory the key manager factory or <code>null</code> to remove any previously set key
         *                          manager factory.
         * @return the builder.
         */
        public @NotNull Builder keyManagerFactory(final @Nullable KeyManagerFactory keyManagerFactory) {
            this.keyManagerFactory = keyManagerFactory;
            return this;
        }

        /**
         * Sets the optional user defined {@link TrustManagerFactory}.
         *
         * @param trustManagerFactory the trust manager factory or <code>null</code> to remove any previously set trust
         *                            manager factory
         * @return the builder.
         */
        public @NotNull Builder trustManagerFactory(final @Nullable TrustManagerFactory trustManagerFactory) {
            this.trustManagerFactory = trustManagerFactory;
            return this;
        }

        /**
         * Sets the optional user defined cipher suites.
         *
         * @param cipherSuites the cipher suites or <code>null</code> to use the default cipher suites of Netty (network
         *                     communication framework).
         * @return the builder.
         */
        public @NotNull Builder cipherSuites(final @NotNull Collection<String> cipherSuites) {
            this.cipherSuites = cipherSuites;
            return this;
        }

        /**
         * Sets the optional user defined protocols.
         *
         * @param protocols the protocols or <code>null</code> to use the default protocols of Netty (network
         *                  communication framework).
         * @return the builder.
         */
        public @NotNull Builder protocols(final @NotNull Collection<String> protocols) {
            this.protocols = protocols;
            return this;
        }

        /**
         * Sets the SSL/TLS handshake timeout}.
         * <p>
         * The timeout in nanoseconds must be in the range: [0, {@link Integer#MAX_VALUE}].
         *
         * @param handshakeTimeout the time unit of the given timeout (this timeout only supports millisecond
         *                         precision).
         * @return the builder.
         */
        public @NotNull Builder handshakeTimeout(final long handshakeTimeout, final @NotNull TimeUnit timeUnit) {
            this.handshakeTimeUnit = timeUnit;
            this.handshakeTimeout = TimeUnit.NANOSECONDS.convert(handshakeTimeout, timeUnit);
            return this;
        }

        /**
         * Sets the optional user defined hostname verifier.
         *
         * @param hostnameVerifier the hostname verifier or <code>null</code> to use https hostname verification.
         * @return the builder.
         * @since 1.2
         */
        public @NotNull Builder hostnameVerifier(final @NotNull HostnameVerifier hostnameVerifier) {
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        public @NotNull Security build() {
            return new Security(userName, password, keyManagerFactory, trustManagerFactory, cipherSuites, protocols,
                    handshakeTimeout, handshakeTimeUnit, hostnameVerifier);
        }
    }
}
