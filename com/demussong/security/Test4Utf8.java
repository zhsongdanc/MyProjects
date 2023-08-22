package com.demussong.security;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/8/24 14:49
 */
public class Test4Utf8 {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "/Users/demussong/Desktop/local2/记录.pdf";
        String encryptPath = "/Users/demussong/Desktop/local2/记录-encrypt.pdf";
        String decryptPath = "/Users/demussong/Desktop/local2/记录-decrypt.pdf";

        String ENCRYPT_TYPE = "AES";
        // 加密秘钥，长度为24字节
        String ENCRYPT_KEY = "smkldospdosldaaasmkldospdosldaaa";

        encrypt(ENCRYPT_TYPE, ENCRYPT_KEY, filePath, encryptPath);
        decrypt(ENCRYPT_TYPE, ENCRYPT_KEY, encryptPath, decryptPath);
    }



    public static void encrypt(String type, String key, String srcPath, String destPath) {
        InputStream in = null;
        CipherInputStream cis = null;
        OutputStream out = null;
        try{
//            byte[] bytes = Base64.getDecoder().decode(key);
//            System.out.println(new String(bytes));
//
//            SecretKey deskey = new SecretKeySpec(bytes, type);
            SecretKey deskey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), type);
            Cipher cipher = Cipher.getInstance(type);
            cipher.init(Cipher.ENCRYPT_MODE, deskey);

            in = new FileInputStream(new File(srcPath));
            cis = new CipherInputStream(in, cipher);
            out = new FileOutputStream(new File(destPath));

            byte[] buffer = new byte[256];
            int i = 0;
            while ((i = cis.read(buffer)) > 0){
                out.write(buffer, 0 , i);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (out != null) {out.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (cis != null) {cis.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (in != null) {in.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void decrypt(String type, String key, String srcPath, String destPath) {
        InputStream in = null;
        OutputStream out = null;
        CipherOutputStream cos = null;
        try{
//            byte[] bytes = Base64.getDecoder().decode(key);
//            System.out.println(new String(bytes));
//
//            SecretKey deskey = new SecretKeySpec(bytes, type);
            SecretKey deskey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), type);
            System.out.println("key=" + deskey.toString());

            Cipher cipher = Cipher.getInstance(type);
            cipher.init(Cipher.DECRYPT_MODE, deskey);

            in = new FileInputStream(new File(srcPath));
            out = new FileOutputStream(new File(destPath));
            cos = new CipherOutputStream(out, cipher);

            byte[] buffer = new byte[256];
            int i = 0;
            while ((i = in.read(buffer)) > 0){
                cos.write(buffer, 0 , i);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (cos != null) {cos.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (out != null) {out.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (in != null) {in.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
