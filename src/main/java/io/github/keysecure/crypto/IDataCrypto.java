package io.github.keysecure.crypto;

public interface IDataCrypto {
    String decode(String cipher);
    String encode(String raw);
}
