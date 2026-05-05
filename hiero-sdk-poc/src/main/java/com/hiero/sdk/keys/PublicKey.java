package com.hiero.sdk.keys;

import org.jspecify.annotations.NonNull;

/**
 * Public key definition.
 */
public interface PublicKey extends Key {

    @Override
    @NonNull
    default KeyType getType() {
        return KeyType.PUBLIC;
    }

    /**
     * Verify a signature using this public key.
     * @param message the original message
     * @param signature the signature to verify
     * @return true if the signature is valid
     */
    boolean verify(@NonNull byte[] message, @NonNull byte[] signature);
}
