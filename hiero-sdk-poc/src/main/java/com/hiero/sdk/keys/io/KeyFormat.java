package com.hiero.sdk.keys.io;

import com.hiero.sdk.keys.KeyType;
import org.jspecify.annotations.NonNull;

/**
 * Combined container format and encoding for keys.
 */
public enum KeyFormat {
    PKCS8_WITH_DER(KeyContainer.PKCS8, KeyEncoding.DER),
    SPKI_WITH_DER(KeyContainer.SPKI, KeyEncoding.DER),
    PKCS8_WITH_PEM(KeyContainer.PKCS8, KeyEncoding.PEM),
    SPKI_WITH_PEM(KeyContainer.SPKI, KeyEncoding.PEM);

    private final KeyContainer container;
    private final KeyEncoding encoding;

    KeyFormat(@NonNull final KeyContainer container, @NonNull final KeyEncoding encoding) {
        this.container = container;
        this.encoding = encoding;
    }

    @NonNull
    public KeyContainer getContainer() {
        return container;
    }

    @NonNull
    public KeyEncoding getEncoding() {
        return encoding;
    }

    public boolean supportsType(@NonNull final KeyType type) {
        return container.supportsType(type);
    }
}

enum KeyContainer {
    PKCS8,
    SPKI;

    public boolean supportsType(@NonNull final KeyType type) {
        return switch (this) {
            case PKCS8 -> type == KeyType.PRIVATE;
            case SPKI -> type == KeyType.PUBLIC;
        };
    }
}

enum KeyEncoding {
    DER,
    PEM
}
