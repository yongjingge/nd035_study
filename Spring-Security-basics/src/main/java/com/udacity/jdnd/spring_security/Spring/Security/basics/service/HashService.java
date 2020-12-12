package com.udacity.jdnd.spring_security.Spring.Security.basics.service;
/**
 * @author SarGould
 * use this class.getHashedValue () to get hashed value of a given String,
 * being used in the UserService.class to get a hashed value of the new user's password.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

@Component
public class HashService {
    private Logger logger = LoggerFactory.getLogger(HashService.class);

    public String getHashedValue (String data, String salt) {
        byte[] hashedValue = null;
        KeySpec spec = new PBEKeySpec(data.toCharArray(), salt.getBytes(), 5000, 128);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            hashedValue = factory.generateSecret(spec).getEncoded();
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            logger.error(e.getMessage());
        }
        return Base64.getEncoder().encodeToString(hashedValue);
    }
}
