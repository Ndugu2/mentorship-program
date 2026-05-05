#include <iostream>
#include <iomanip>
#include "hiero/keys/Ed25519PrivateKey.hpp"

using namespace hiero::sdk::keys;

void print_hex(const std::string& label, const std::vector<uint8_t>& bytes) {
    std::cout << label << ": ";
    for (auto b : bytes) {
        std::cout << std::hex << std::setw(2) << std::setfill('0') << static_cast<int>(b);
    }
    std::cout << std::dec << std::endl;
}

int main() {
    std::cout << "=== Hiero SDK V3 C++ PoC Demo ===" << std::endl;

    // 1. Generate Key
    auto privateKey = Ed25519PrivateKey::generate();
    std::cout << "\n[1] Generated Ed25519 Private Key" << std::endl;
    print_hex("Private Key Bytes", privateKey->getBytes());

    // 2. Derive Public Key
    auto publicKey = privateKey->createPublicKey();
    std::cout << "\n[2] Derived Public Key" << std::endl;
    print_hex("Public Key Bytes ", publicKey->getBytes());

    // 3. Sign Message
    std::vector<uint8_t> message = {0x01, 0x02, 0x03, 0x04};
    auto signature = privateKey->sign(message);
    std::cout << "\n[3] Signed Mock Message" << std::endl;
    std::cout << "Signature generated (64 bytes mock)." << std::endl;

    std::cout << "\n=== C++ PoC Demo Completed ===" << std::endl;

    return 0;
}
