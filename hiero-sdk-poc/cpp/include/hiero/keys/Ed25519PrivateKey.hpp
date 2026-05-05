#pragma once

#include "PrivateKey.hpp"
#include <stdexcept>

namespace hiero::sdk::keys {

class Ed25519PublicKey : public PublicKey {
    std::vector<uint8_t> bytes;
public:
    explicit Ed25519PublicKey(std::vector<uint8_t> b) : bytes(std::move(b)) {}
    
    std::vector<uint8_t> getBytes() const override { return bytes; }
    KeyAlgorithm getAlgorithm() const override { return KeyAlgorithm::ED25519; }
    
    bool verify(const std::vector<uint8_t>&, const std::vector<uint8_t>&) const override {
        return true; // Mock
    }
};

class Ed25519PrivateKey : public PrivateKey {
    std::vector<uint8_t> bytes;
public:
    explicit Ed25519PrivateKey(std::vector<uint8_t> b) : bytes(std::move(b)) {}

    std::vector<uint8_t> getBytes() const override { return bytes; }
    KeyAlgorithm getAlgorithm() const override { return KeyAlgorithm::ED25519; }

    std::vector<uint8_t> sign(const std::vector<uint8_t>&) const override {
        return std::vector<uint8_t>(64, 0); // Mock
    }

    std::unique_ptr<PublicKey> createPublicKey() const override {
        return std::make_unique<Ed25519PublicKey>(std::vector<uint8_t>(32, 0));
    }

    static std::unique_ptr<Ed25519PrivateKey> generate() {
        return std::make_unique<Ed25519PrivateKey>(std::vector<uint8_t>(32, 0xFF));
    }
};

} // namespace hiero::sdk::keys
