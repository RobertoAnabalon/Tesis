package main.java.Encryption;

public class SecureStorageService {
    private final EncryptionContext encryptionContext;

    public SecureStorageService(EncryptionContext encryptionContext) {
        this.encryptionContext = encryptionContext;
    }

    public String encrypt(String data) {
        try {
            String encryptedData = encryptionContext.encrypt(data);
            System.out.println("Resultado del cifrado : " + encryptedData);
            return encryptedData;
        } catch (Exception e) {
            System.err.println("Error al cifrar: " + e.getMessage());
            return null;
        }
    }

    public String decrypt(String encryptedData) {
        try {
            String decryptedData = encryptionContext.decrypt(encryptedData);
            System.out.println("Resultado del descifrado: " + decryptedData);
            return decryptedData;
        } catch (Exception e) {
            System.err.println("Error al descifrar: " + e.getMessage());
            return null;
        }
    }
}
