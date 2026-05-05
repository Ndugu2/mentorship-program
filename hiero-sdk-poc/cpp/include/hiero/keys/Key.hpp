#pragma once

#include <vector>
#include <cstdint>
#include <string>
#include "KeyAlgorithm.hpp"
#include "KeyType.hpp"

namespace hiero::sdk::keys {

/**
 * Base interface for all keys in the Hiero SDK V3 C++ PoC.
 */
class Key {
public:
    virtual ~Key() = default;

    /**
     * Returns the raw bytes of the key.
     */
    virtual std::vector<uint8_t> getBytes() const = 0;

    /**
     * Returns the algorithm of the key.
     */
    virtual KeyAlgorithm getAlgorithm() const = 0;

    /**
     * Returns the type of the key (PUBLIC or PRIVATE).
     */
    virtual KeyType getType() const = 0;

    /**
     * Returns the key in the RAW encoding.
     */
    virtual std::vector<uint8_t> toRawBytes() const {
        return getBytes();
    }
};

} // namespace hiero::sdk::keys
