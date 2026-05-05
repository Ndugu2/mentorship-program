#pragma once

#include <memory>
#include "Key.hpp"
#include "PublicKey.hpp"

namespace hiero::sdk::keys {

/**
 * Private key interface.
 */
class PrivateKey : public virtual Key {
public:
    KeyType getType() const override {
        return KeyType::PRIVATE;
    }

    /**
     * Sign a message with this private key.
     */
    virtual std::vector<uint8_t> sign(const std::vector<uint8_t>& message) const = 0;

    /**
     * Derive the corresponding public key.
     */
    virtual std::unique_ptr<PublicKey> createPublicKey() const = 0;
};

} // namespace hiero::sdk::keys
