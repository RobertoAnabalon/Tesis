package main.java.Encryption;

public class AlgorithmC implements EncryptionAlgorithm {
    @Override
    public String encrypt(String data) {
        return "encryptedC:" + data;
    }

    @Override
    public String decrypt(String data) {
        return data.replace("encryptedC:", "");
    }
}
//En caso de haber un tercero o aún mas algoritmos