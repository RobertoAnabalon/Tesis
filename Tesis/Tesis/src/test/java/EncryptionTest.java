package test.java;

import java.security.NoSuchAlgorithmException;
import main.java.Encryption.*;
import main.java.management.*;

public class EncryptionTest {
    public static void main(String[] args) throws NoSuchAlgorithmException, Exception {
        // Instancia y configuración del algoritmo AES
        EncryptionAlgorithm aesAlgorithm = new AESAlgorithm();  // Algoritmo AES
        EncryptionContext aesContext = new EncryptionContext();
        aesContext.setEncryptionAlgorithm(aesAlgorithm);
        SecureStorageService aesSecureStorage = new SecureStorageService(aesContext);
        StorageManager aesStorageManager = new StorageManager(aesSecureStorage);

        // Instancia y configuración del algoritmo RSA
        EncryptionAlgorithm rsaAlgorithm = new RSAAlgorithm();  // Algoritmo RSA
        EncryptionContext rsaContext = new EncryptionContext();
        rsaContext.setEncryptionAlgorithm(rsaAlgorithm);
        SecureStorageService rsaSecureStorage = new SecureStorageService(rsaContext);
        StorageManager rsaStorageManager = new StorageManager(rsaSecureStorage);

        // Datos de prueba
        String data = "Datos sensibles de prueba";

        // Guardar y recuperar datos usando AES
        aesStorageManager.saveData("usuario1_aes", data);
        String encryptedDataAES = aesStorageManager.getData("usuario1_aes");
        if (encryptedDataAES != null) {
            System.out.println("Datos descifrados con AES: " + encryptedDataAES);
        

        // Guardar y recuperar datos usando RSA
        rsaStorageManager.saveData("usuario1_rsa", data);
        String encryptedDataRSA = rsaStorageManager.getData("usuario1_rsa");
        if (encryptedDataRSA != null) {
            System.out.println("Datos descifrados con RSA: " + encryptedDataRSA);
        }
    }
}
}
