# Hiero SDK V3 Java PoC

This is a Proof of Concept (PoC) implementation of the Hiero SDK V3 Keys API, following the [Hiero SDK API Guidelines](https://github.com/hiero-ledger/sdk-collaboration-hub/blob/main/guides/api-guideline.md) and [Java Best Practices](https://github.com/hiero-ledger/sdk-collaboration-hub/blob/main/guides/api-best-practices-java.md).

## Key Features Implemented:
- **Language-Agnostic Alignment**: Implemented `Key`, `PublicKey`, `PrivateKey`, and `KeyPair` as defined in the meta-language.
- **Immutability**: Used Java `record` for `KeyPair` and ensured all interfaces promote immutable patterns.
- **Null Safety**: Applied `@NonNull` annotations and `Objects.requireNonNull` validation on all public API boundaries.
- **Type Safety**: Mapped meta-language enums (`KeyType`, `KeyAlgorithm`) directly to Java enums.
- **Internal Consistency**: Followed the naming conventions and structure required for the V3 SDK architecture.

## Directory Structure:
- `com.hiero.sdk`: Core transaction architecture.
- `com.hiero.sdk.keys`: Core key abstractions and algorithms.
- `com.hiero.sdk.keys.io`: Key formats, containers, and encodings for import/export.
- `com.hiero.sdk.demo`: Executable demo to showcase the V3 architecture.

## How to Run:
To compile and run the demo, navigate to the `src/main/java` directory and run:
```bash
javac -d . $(find . -name "*.java")
java com.hiero.sdk.demo.Main
```
(On Windows PowerShell):
```powershell
javac -d . (Get-ChildItem -Recurse -Filter *.java).FullName
java com.hiero.sdk.demo.Main
```

## Cross-Language Consistency (Java & C++)
The SDK V3 vision emphasizes a language-agnostic architecture. This repository contains both a **Java** and a **C++** PoC that implement the exact same cryptographic interfaces.

| Concept | Java Implementation | C++ Implementation |
|---------|---------------------|--------------------|
| Interface | `interface PrivateKey` | `class PrivateKey` |
| Byte Array | `byte[]` | `std::vector<uint8_t>` |
| Immutability | `record KeyPair` | `const` member functions |
| Error Handling | `Exceptions` | `std::runtime_error` |

This demonstrates that the Hiero SDK V3 "meta-language" can be successfully projected onto different programming paradigms while maintaining 100% consistency in developer experience.
