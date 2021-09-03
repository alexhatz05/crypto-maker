package com.acrypto.encryption;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CryptoCipher {
    private static final Logger logger = Logger.getLogger(CryptoCipher.class.getName());
    private static final String EXCEPTION_MESSAGE = "Exception occurred!";

    String cipherAlgorithm;
    String encOrDec;
    String cipherMode;
    String text;

    private Cipher cipher;

    /*Used for encryption*/
    public CryptoCipher(String cipherAlgorithm, String encOrDec, String cipherMode, String plaintext) {
        this.cipherAlgorithm = cipherAlgorithm;
        this.encOrDec = encOrDec;
        this.cipherMode = cipherMode;
        this.text = plaintext;
        this.initializeCipher();
    }

    /*Used for decryption*/
    public CryptoCipher(String cipherAlgorithm, String encOrDec, String cipherMode, String ciphertext, String key) {
        this.cipherAlgorithm = cipherAlgorithm;
        this.encOrDec = encOrDec;
        this.cipherMode = cipherMode;
        this.text = ciphertext;
        this.initializeCipher(key);
    }

    /*Used for encryption*/
    private void initializeCipher() {
        KeyGeneration keyGen = new KeyGeneration();

        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, keyGen.generateSymmetricKey());
        }
        catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
            logger.log(Level.SEVERE, EXCEPTION_MESSAGE, e);
        }
    }

    /*Used for decryption*/
    private void initializeCipher(String key) {
        SecretKey originalKey = new SecretKeySpec(key.getBytes(), 0, key.getBytes().length, "AES");

        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, originalKey);
        }
        catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
            logger.log(Level.SEVERE, EXCEPTION_MESSAGE, e);
        }
    }

    public byte[] executeCipher() {
        byte[] plainOrCipherText = "".getBytes();
        try {
            plainOrCipherText = cipher.doFinal(this.text.getBytes());
        }
        catch (IllegalBlockSizeException | BadPaddingException e) {
            logger.log(Level.SEVERE, EXCEPTION_MESSAGE, e);
        }
        return plainOrCipherText;
    }
}
