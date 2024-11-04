package main.java.Encryption;

import main.java.management.StorageManager;

public class SecureStorageService {

    private final StorageManager storageManager;


    public SecureStorageService(StorageManager storageManager) {
        this.storageManager = storageManager;
    }

    public void storeSensitiveData(String key, String data) throws Exception {
        storageManager.storeData(key, data);
    }

    public String retrieveSensitiveData(String key) throws Exception {
        return storageManager.retrieveData(key);
    }
}