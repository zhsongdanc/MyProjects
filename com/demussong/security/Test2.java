package com.demussong.security;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

/*
 * @Author: demussong
 * @Description:  自己封装的outputstream
 * @Date: 2022/8/24 11:51
 */
public class Test2 {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "/Users/demussong/Desktop/testXLSX.xlsx";
        String encryptPath = "/Users/demussong/Desktop/testen100.xlsx";
        String decryptPath = "/Users/demussong/Desktop/testde100.xlsx";

        String ENCRYPT_TYPE = "AES";
        // 加密秘钥，长度为24字节
        String ENCRYPT_KEY = "aSVal7vPgQ2BaFUpJFFb2bIoo+Kjd1SlA1iacXv49EE=";

        encrypt(ENCRYPT_TYPE, ENCRYPT_KEY, filePath, encryptPath);
        decrypt(ENCRYPT_TYPE, ENCRYPT_KEY, encryptPath, decryptPath);


    }

    public static void encrypt(String type, String key, String srcPath, String destPath) {
        InputStream in = null;
        OutputStream out = null;
        MultiPartCipherOutputStream cos = null;
        try{

            byte[] bytes = Base64.getDecoder().decode(key);
            System.out.println(new String(bytes));

            SecretKey deskey = new SecretKeySpec(bytes, type);


//            SecretKey deskey = new SecretKeySpec(key.getBytes(), type);
//            Cipher cipher = Cipher.getInstance(type);
//            cipher.init(Cipher.ENCRYPT_MODE, deskey);
            CipherLite cipherLite = new EncryptCipherLite(deskey);

            in = new FileInputStream(new File(srcPath));
            out = new FileOutputStream(new File(destPath));
            cos = new MultiPartCipherOutputStream(out, cipherLite);

            byte[] buffer = new byte[100];
            int i = 0;
            while ((i = in.read(buffer)) > 0){
                System.out.println(i);
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

    public static void decrypt(String type, String key, String srcPath, String destPath) {
        InputStream in = null;
        OutputStream out = null;
        CipherOutputStream cos = null;
        try{
//            SecretKey deskey = new SecretKeySpec(key.getBytes(), type);
            byte[] bytes = Base64.getDecoder().decode(key);
            System.out.println(new String(bytes));

            SecretKey deskey = new SecretKeySpec(bytes, type);
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
