package main.java.Encryption;

public class EncryptionContext {
    private EncryptionAlgorithm encryptionAlgorithm;

    // Método para establecer el algoritmo de cifrado
    public void setEncryptionAlgorithm(EncryptionAlgorithm encryptionAlgorithm) {
        this.encryptionAlgorithm = encryptionAlgorithm;
    }

    public String encrypt(String data) throws Exception {
        if (encryptionAlgorithm == null) {
            throw new IllegalStateException("El algoritmo de cifrado no ha sido configurado.");
        }
        return encryptionAlgorithm.encrypt(data);
    }

    public String decrypt(String encryptedData) throws Exception {
        if (encryptionAlgorithm == null) {
            throw new IllegalStateException("El algoritmo de cifrado no ha sido configurado.");
        }
        return encryptionAlgorithm.decrypt(encryptedData);
    }
}
