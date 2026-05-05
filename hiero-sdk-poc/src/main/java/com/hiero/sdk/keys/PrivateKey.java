package com.hiero.sdk.keys;

import org.jspecify.annotations.NonNull;

/**
 * Private key definition.
 */
public interface PrivateKey extends Key {

    @Override
    @NonNull
    default KeyType getType() {
        return KeyType.PRIVATE;
    }

    /**
     * Sign a message with this private key.
     * @param message the message to sign
     * @return the signature
     */
    @NonNull
    byte[] sign(@NonNull byte[] message);

    /**
     * Derive the corresponding public key.
     * @return a new PublicKey instance
     */
    @NonNull
    PublicKey createPublicKey();

    /**
     * Generates a new random private key for the specified algorithm.
     * @param algorithm the algorithm to use
     * @return a new PrivateKey instance
     */
    @NonNull
    static PrivateKey generate(@NonNull KeyAlgorithm algorithm) {
        // Implementation will be provided by concrete classes or a factory
        return switch (algorithm) {
            case ED25519 -> Ed25519PrivateKey.generate();
            case ECDSA -> throw new UnsupportedOperationException("ECDSA not yet implemented in PoC");
        };
    }

    /**
     * Loads a private key from raw bytes for the specified algorithm.
     * @param algorithm the algorithm to use
     * @param bytes the raw key bytes
     * @return a PrivateKey instance
     */
    @NonNull
    static PrivateKey fromBytes(@NonNull KeyAlgorithm algorithm, @NonNull byte[] bytes) {
        return switch (algorithm) {
            case ED25519 -> new Ed25519PrivateKey(bytes);
            case ECDSA -> throw new UnsupportedOperationException("ECDSA not yet implemented in PoC");
        };
    }
}
