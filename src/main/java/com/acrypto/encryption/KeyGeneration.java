package com.acrypto.encryption;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeyGeneration {
    private static final Logger logger = Logger.getLogger(KeyGeneration.class.getName());

    public SecretKey generateSymmetricKey() {
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = new SecureRandom();
            int keyBitSize = 128;
            keyGenerator.init(keyBitSize, secureRandom);
        }
        catch (NoSuchAlgorithmException e) {
            logger.log(Level.SEVERE, "Exception occurred!", e);
        }

        return keyGenerator != null ? keyGenerator.generateKey() : null;
    }
}
