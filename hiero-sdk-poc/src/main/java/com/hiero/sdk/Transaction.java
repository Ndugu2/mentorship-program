package com.hiero.sdk;

import com.hiero.sdk.keys.PrivateKey;
import org.jspecify.annotations.NonNull;
import java.util.Optional;

/**
 * Base interface for all Hiero transactions, following the SDK V3 functional/immutable design.
 */
public interface Transaction<T extends Transaction<T>> {

    /**
     * Signs the transaction with the provided private key.
     * @param privateKey the key to sign with
     * @return a new instance of the transaction containing the signature
     */
    @NonNull
    T sign(@NonNull PrivateKey privateKey);

    /**
     * Returns the ID of the transaction if it has been assigned.
     * @return the transaction ID
     */
    @NonNull
    Optional<String> getTransactionId();

    /**
     * Freezes the transaction to prevent further modifications before signing.
     * @return a frozen version of the transaction
     */
    @NonNull
    T freeze();
}
