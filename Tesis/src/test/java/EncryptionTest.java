package test.java;
    import main.java.Encryption.AESAlgorithm;
    import main.java.Encryption.EncryptionContext;
    import main.java.Encryption.RSAAlgorithm;
    
    public class EncryptionTest{
    
        public static void main(String[] args) throws Exception {
            // RSA y AES algoritmos
            RSAAlgorithm rsaAlgorithm = new RSAAlgorithm();
            AESAlgorithm aesAlgorithm = new AESAlgorithm();
            EncryptionContext encryptionContext = new EncryptionContext();
            
            // TEST CON AES
            encryptionContext.setAlgorithm(aesAlgorithm);
            String aesEncrypted = encryptionContext.encryptData("Hola, texto/data sensible encriptado con AES");
            System.out.println("AES Encriptado: " + aesEncrypted);
            String aesDecrypted = encryptionContext.decryptData(aesEncrypted);
            System.out.println("AES Desencripado: " + aesDecrypted);
            
            // TEST CON RSA
            encryptionContext.setAlgorithm(rsaAlgorithm);
            String rsaEncrypted = encryptionContext.encryptData("Hola, texto/data sensible encriptado con RSA");
            System.out.println("RSA Encriptado: " + rsaEncrypted);
            String rsaDecrypted = encryptionContext.decryptData(rsaEncrypted);
            System.out.println("RSA Desencriptado: " + rsaDecrypted);
        }
    }
    

