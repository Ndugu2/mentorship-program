package com.hiero.sdk.demo;

import com.hiero.sdk.TransferTransaction;
import com.hiero.sdk.keys.KeyAlgorithm;
import com.hiero.sdk.keys.PrivateKey;
import com.hiero.sdk.keys.PublicKey;
import com.hiero.sdk.keys.io.KeyFormat;

/**
 * A simple demo to showcase the Hiero SDK V3 PoC.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hiero SDK V3 PoC Demo ===");

        // 1. Generate a new Ed25519 Private Key
        System.out.println("\n[1] Generating Ed25519 Private Key...");
        PrivateKey privateKey = PrivateKey.generate(KeyAlgorithm.ED25519);
        System.out.println("Private Key (Hex): " + privateKey.toString(KeyFormat.PKCS8_WITH_DER));

        // 2. Derive Public Key
        System.out.println("\n[2] Deriving Public Key...");
        PublicKey publicKey = privateKey.createPublicKey();
        System.out.println("Public Key (Hex):  " + publicKey.toString(KeyFormat.SPKI_WITH_DER));

        // 3. Create a Transfer Transaction
        System.out.println("\n[3] Creating Transfer Transaction...");
        TransferTransaction transaction = TransferTransaction.create()
                .setMemo("Hiero SDK V3 Mentorship PoC");
        
        System.out.println("Transaction Memo: " + transaction.getMemo());

        // 4. Freeze and Sign
        System.out.println("\n[4] Freezing and Signing Transaction...");
        TransferTransaction signedTx = transaction
                .freeze()
                .sign(privateKey);

        System.out.println("Transaction successfully frozen and signed.");
        System.out.println("\n=== Demo Completed Successfully ===");
    }
}
