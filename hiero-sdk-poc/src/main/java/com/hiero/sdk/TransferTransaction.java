package com.hiero.sdk;

import com.hiero.sdk.keys.PrivateKey;
import org.jspecify.annotations.NonNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * A transaction that transfers Hbar between accounts.
 */
public final class TransferTransaction implements Transaction<TransferTransaction> {

    private final List<byte[]> signatures;
    private final String memo;
    private final boolean frozen;

    private TransferTransaction(List<byte[]> signatures, String memo, boolean frozen) {
        this.signatures = Collections.unmodifiableList(signatures);
        this.memo = memo;
        this.frozen = frozen;
    }

    public static TransferTransaction create() {
        return new TransferTransaction(new ArrayList<>(), "", false);
    }

    @Override
    @NonNull
    public TransferTransaction sign(@NonNull PrivateKey privateKey) {
        if (!frozen) {
            throw new IllegalStateException("Transaction must be frozen before signing");
        }
        // In V3, we return a new instance with the new signature
        List<byte[]> newSignatures = new ArrayList<>(signatures);
        newSignatures.add(privateKey.sign(new byte[32])); // Mock signing
        return new TransferTransaction(newSignatures, memo, frozen);
    }

    @Override
    @NonNull
    public Optional<String> getTransactionId() {
        return Optional.empty();
    }

    @Override
    @NonNull
    public TransferTransaction freeze() {
        return new TransferTransaction(signatures, memo, true);
    }

    @NonNull
    public TransferTransaction setMemo(@NonNull String memo) {
        if (frozen) {
            throw new IllegalStateException("Cannot modify a frozen transaction");
        }
        return new TransferTransaction(signatures, memo, frozen);
    }

    @NonNull
    public String getMemo() {
        return memo;
    }
}
