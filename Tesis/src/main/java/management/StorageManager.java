package main.java.management;

import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;

import main.java.Encryption.AESAlgorithm;
import main.java.Encryption.EncryptionContext;
import main.java.Encryption.RSAAlgorithm;

public class StorageManager {

    private final EncryptionContext encryptionContext;
    private final AESAlgorithm aesAlgorithm;
    private final RSAAlgorithm rsaAlgorithm;

    public StorageManager(EncryptionContext encryptionContext, AESAlgorithm aesAlgorithm, RSAAlgorithm rsaAlgorithm) {
        this.encryptionContext = encryptionContext;
        this.aesAlgorithm = aesAlgorithm;
        this.rsaAlgorithm = rsaAlgorithm;
    }

    public void storeData(String key, String data) throws Exception {
        // Cifrar los datos con AES
        encryptionContext.setAlgorithm(aesAlgorithm);
        String encryptedData = encryptionContext.encryptData(data);
        
        // Cifrar la clave AES con RSA
        encryptionContext.setAlgorithm(rsaAlgorithm);
        String encryptedAESKey = encryptionContext.encryptData(Base64.getEncoder().encodeToString(aesAlgorithm.getSecretKey().getEncoded()));

        System.out.println("Storing encrypted data: " + encryptedData);
        System.out.println("Storing encrypted AES key: " + encryptedAESKey);

        // Se guarda *encryptedData* y *encryptedAESKey* en la base de datos o almacenamiento deseado
    }

    public String retrieveData(String key) throws Exception {
        // Recuperar datos cifrados y clave AES cifrada del almacenamiento simulado aquí
        String encryptedData = "encrypted_data_from_storage"; // Place holder
        String encryptedAESKey = "encrypted_aes_key_from_storage"; // Place holder

        // Descifrar la clave AES con RSA
        encryptionContext.setAlgorithm(rsaAlgorithm);
        String decryptedAESKey = encryptionContext.decryptData(encryptedAESKey);
        byte[] decodedKey = Base64.getDecoder().decode(decryptedAESKey);
        AESAlgorithm aesAlgorithmWithDecryptedKey = new AESAlgorithm(new SecretKeySpec(decodedKey, "AES"));

        // Usar la clave AES descifrada para descifrar los datos
        encryptionContext.setAlgorithm(aesAlgorithmWithDecryptedKey);
        return encryptionContext.decryptData(encryptedData);
    }
}
