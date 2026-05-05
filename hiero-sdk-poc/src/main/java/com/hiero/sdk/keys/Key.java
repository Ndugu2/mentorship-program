package com.hiero.sdk.keys;

import com.hiero.sdk.keys.io.KeyFormat;
import java.util.Objects;
import org.jspecify.annotations.NonNull;

/**
 * Abstract key definition.
 */
public interface Key {

    /**
     * Returns the raw bytes of the key.
     * @return the raw bytes
     */
    @NonNull
    byte[] getBytes();

    /**
     * Returns the algorithm of the key.
     * @return the key algorithm
     */
    @NonNull
    KeyAlgorithm getAlgorithm();

    /**
     * Returns the type of the key (PUBLIC or PRIVATE).
     * @return the key type
     */
    @NonNull
    KeyType getType();

    /**
     * Convert to bytes using specified container format.
     * @param container the format to use
     * @return the key bytes in the specified format
     * @throws IllegalArgumentException if container format is not BYTES
     */
    @NonNull
    byte[] toBytes(@NonNull KeyFormat container);

    /**
     * Convert to string using specified container format.
     * @param container the format to use
     * @return the key as a string in the specified format
     * @throws IllegalArgumentException if container format is not STRING
     */
    @NonNull
    String toString(@NonNull KeyFormat container);

    /**
     * Returns the key in the RAW encoding.
     * @return the raw bytes
     */
    @NonNull
    default byte[] toRawBytes() {
        return getBytes();
    }
}
