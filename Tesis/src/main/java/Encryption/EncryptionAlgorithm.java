package main.java.Encryption;

public interface EncryptionAlgorithm {
    String encrypt(String data) throws Exception;
    String decrypt(String data) throws Exception;
}

