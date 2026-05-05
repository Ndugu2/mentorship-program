package com.hiero.sdk.keys;

import java.util.Objects;
import org.jspecify.annotations.NonNull;

/**
 * A key pair containing a public and a private key.
 */
public record KeyPair(@NonNull PublicKey publicKey, @NonNull PrivateKey privateKey) {

    public KeyPair {
        Objects.requireNonNull(publicKey, "publicKey must not be null");
        Objects.requireNonNull(privateKey, "privateKey must not be null");
    }
}
