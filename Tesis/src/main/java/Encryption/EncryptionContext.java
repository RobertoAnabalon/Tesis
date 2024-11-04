package main.java.Encryption;

import java.util.Base64;


public class EncryptionContext {

    private EncryptionAlgorithm algorithm;

    // Metodo rsa o aes para encriptar
    public void setAlgorithm(EncryptionAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String encryptData(String data) throws Exception {
        if (algorithm == null) {
            throw new IllegalStateException("ERROR: algoritmo no seteado. Implementar método ecriptado/desencriptado"); //en caso de no tener el algoritmo en el encryption storage
        }
        return algorithm.encrypt(data);
    }

    // Desencriptado
    public String decryptData(String data) throws Exception {
        if (algorithm == null) {
            throw new IllegalStateException("ERROR: algoritmo no seteado. Implementar desencriptado");
        }
        return algorithm.decrypt(data);
    }
}

