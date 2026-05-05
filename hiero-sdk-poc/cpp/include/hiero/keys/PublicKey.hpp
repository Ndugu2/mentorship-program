#pragma once

#include "Key.hpp"

namespace hiero::sdk::keys {

/**
 * Public key interface.
 */
class PublicKey : public virtual Key {
public:
    KeyType getType() const override {
        return KeyType::PUBLIC;
    }

    /**
     * Verify a signature using this public key.
     */
    virtual bool verify(const std::vector<uint8_t>& message, const std::vector<uint8_t>& signature) const = 0;
};

} // namespace hiero::sdk::keys
