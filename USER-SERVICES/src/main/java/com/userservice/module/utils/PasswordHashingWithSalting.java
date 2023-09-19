package com.userservice.module.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;
import java.util.Base64;

public class PasswordHashingWithSalting {
    public static final int SALT_LENGTH = 16;
    public static final int STRENGTH = 12;

//    String password = "MyPassword123";
//    String hashedPassword = hashPassword(password);
//        System.out.println("Password: " + password);
//        System.out.println("Hashed password with salt: " + hashedPassword);
//
//    // Assume the encrypted password is retrieved from the database
//    String encryptedPasswordFromDatabase = hashedPassword;
//
//    // Check if the entered password matches the encrypted password in the database
//    boolean isMatch = checkPassword(password, encryptedPasswordFromDatabase);
//
//        if (isMatch) {
//        System.out.println("Passwords match!");
//    } else {
//        System.out.println("Passwords do not match!");
//    }


    public String hashPassword(String password){
        byte[] salt = generateSalt();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(STRENGTH,new SecureRandom(salt));
        String hashedPassword = passwordEncoder.encode(password);
        return encodeBase64(salt) + ":" + hashedPassword;
    }

    public static boolean checkPassword(String password, String hashedPasswordWithSalt) {
        String[] parts = hashedPasswordWithSalt.split(":");
        byte[] salt = decodeBase64(parts[0]);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(STRENGTH, new SecureRandom(salt));
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword.equals(parts[1]);
    }

    public static byte[] generateSalt(){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return salt;
    }

    public static String encodeBase64(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    public static byte[] decodeBase64(String base64Data) {
        return Base64.getDecoder().decode(base64Data);
    }

}
