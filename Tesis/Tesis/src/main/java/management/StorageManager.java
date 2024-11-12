package main.java.management;

import java.util.HashMap;
import java.util.Map;

import main.java.Encryption.SecureStorageService;

public class StorageManager {
    private final SecureStorageService secureStorageService;
    private final Map<String, String> storage = new HashMap<>();

    public StorageManager(SecureStorageService secureStorageService) {
        this.secureStorageService = secureStorageService;
    }

    public void saveData(String key, String data) {
        String encryptedData = secureStorageService.encrypt(data);
        if (encryptedData != null) {
            System.out.println("Guardando datos cifrados con clave: " + key);
            storage.put(key, encryptedData);
        } else {
            System.err.println("Error al guardar los datos.");
        }
    }

    public String getData(String key) {
        String encryptedData = storage.get(key);
        if (encryptedData == null) {
            System.out.println("No se encontraron datos para la clave: " + key);
            return null;
        }
        System.out.println("Datos recuperados (cifrados) para la clave: " + key + " - " + encryptedData);
        return secureStorageService.decrypt(encryptedData);
    }
}