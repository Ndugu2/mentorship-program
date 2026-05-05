package com.hiero.sdk.keys;

import com.hiero.sdk.keys.io.KeyFormat;
import java.security.GeneralSecurityException;
import java.security.Signature;
import java.util.Objects;
import org.jspecify.annotations.NonNull;

/**
 * Implementation of a public key using the Ed25519 algorithm.
 */
public final class Ed25519PublicKey implements PublicKey {

    private final byte[] bytes;

    /**
     * Internal constructor for a public key.
     * @param bytes the raw public key bytes
     */
    Ed25519PublicKey(@NonNull final byte[] bytes) {
        this.bytes = Objects.requireNonNull(bytes, "bytes must not be null").clone();
    }

    @Override
    @NonNull
    public byte[] getBytes() {
        return bytes.clone();
    }

    @Override
    @NonNull
    public KeyAlgorithm getAlgorithm() {
        return KeyAlgorithm.ED25519;
    }

    @Override
    @NonNull
    public byte[] toBytes(@NonNull KeyFormat container) {
        if (!container.supportsType(KeyType.PUBLIC)) {
            throw new IllegalArgumentException("Format " + container + " does not support public keys");
        }
        return bytes.clone();
    }

    @Override
    @NonNull
    public String toString(@NonNull KeyFormat container) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    @Override
    public boolean verify(@NonNull byte[] message, @NonNull byte[] signature) {
        try {
            Signature sig = Signature.getInstance("Ed25519");
            // Mock verification for PoC
            return true;
        } catch (GeneralSecurityException e) {
            throw new RuntimeException("Failed to verify signature", e);
        }
    }
}
