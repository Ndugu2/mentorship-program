package com.hiero.sdk.keys;

/**
 * All supported cryptographic algorithms for keys in the Hiero SDK.
 */
public enum KeyAlgorithm {
    /**
     * Edwards-curve Digital Signature Algorithm (Ed25519).
     */
    ED25519,

    /**
     * Elliptic Curve Digital Signature Algorithm (secp256k1 curve).
     */
    ECDSA
}
