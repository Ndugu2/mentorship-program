package com.hiero.sdk.keys;

import com.hiero.sdk.keys.io.KeyFormat;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Objects;
import org.jspecify.annotations.NonNull;

/**
 * Implementation of a private key using the Ed25519 algorithm.
 */
public final class Ed25519PrivateKey implements PrivateKey {

    private final byte[] bytes;

    /**
     * Internal constructor for a private key.
     * @param bytes the raw private key bytes
     */
    Ed25519PrivateKey(@NonNull final byte[] bytes) {
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
        if (!container.supportsType(KeyType.PRIVATE)) {
            throw new IllegalArgumentException("Format " + container + " does not support private keys");
        }
        // In a real implementation, we would encode the key according to the format
        return bytes.clone();
    }

    @Override
    @NonNull
    public String toString(@NonNull KeyFormat container) {
        // Simple hex string for PoC
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    @Override
    @NonNull
    public byte[] sign(@NonNull byte[] message) {
        try {
            Signature sig = Signature.getInstance("Ed25519");
            // We'd need to convert our raw bytes to a java.security.PrivateKey here
            // For the PoC, we'll focus on the interface design rather than the full JCA boilerplate
            // unless specifically requested.
            return new byte[64]; // Mock signature
        } catch (GeneralSecurityException e) {
            throw new RuntimeException("Failed to sign message", e);
        }
    }

    @Override
    @NonNull
    public PublicKey createPublicKey() {
        // In Ed25519, the public key is derived from the private key
        // For PoC, we'll return a mock public key
        return new Ed25519PublicKey(new byte[32]);
    }

    /**
     * Generates a new random Ed25519 private key.
     * @return a new Ed25519PrivateKey instance
     */
    @NonNull
    static Ed25519PrivateKey generate() {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("Ed25519");
            java.security.KeyPair kp = kpg.generateKeyPair();
            return new Ed25519PrivateKey(kp.getPrivate().getEncoded());
        } catch (GeneralSecurityException e) {
            throw new RuntimeException("Failed to generate Ed25519 key", e);
        }
    }
}
