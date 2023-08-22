package com.demussong.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/*
 * @Author: demussong
 * @Description: 使用doFinal加密
 * @Date: 2022/11/21 11:49
 */
public class DoFinalTest {

    public static void main(String[] args) throws Exception {
        String type = "AES";
        String key = "smkldospdosldaaasmkldospdosldaaa";
        byte[] decrypt = decrypt(type, key, encrypt(type, key));
        System.out.println(new String(decrypt));
    }

    public static byte[] encrypt(String type, String key) throws Exception{
        String msg = "This is demus!";
        Cipher cipher = Cipher.getInstance(type);
        SecretKey deskey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), type);
        cipher.init(Cipher.ENCRYPT_MODE, deskey);
        cipher.update(msg.getBytes(StandardCharsets.UTF_8));
        return cipher.doFinal(msg.getBytes(StandardCharsets.UTF_8));
    }

    public static byte[] decrypt(String type, String key, byte[] encrypted) throws Exception{
        Cipher cipher = Cipher.getInstance(type);
        SecretKey deskey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), type);
        cipher.init(Cipher.DECRYPT_MODE, deskey);
        byte[] update = cipher.update(encrypted);
        return cipher.doFinal(encrypted);
    }
}
