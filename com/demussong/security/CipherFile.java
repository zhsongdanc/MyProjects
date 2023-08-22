package com.demussong.security;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/8/24 15:36
 */

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;

/**
 * 使用 Cipher CipherInputStream CipherOutputStream 实现对文件的加解密
 * @auther jinsx
 * @date 2019-04-05 15:22
 */
public class CipherFile {

    // 加密类型，支持这三种DESede,Blowfish,AES
    private static final String ENCRYPT_TYPE = "AES";
    // 加密秘钥，长度为24字节
    private static final String ENCRYPT_KEY = "mQbJILokBccRHUkS+XBk7A==";

    /**
     * 加密文件
     * @param srcFileName  要加密的文件
     * @param destFileName 加密后存放的文件名
     */
    public boolean encryptFile(String srcFileName, String destFileName) {
        InputStream is = null;
        OutputStream out = null;
        CipherInputStream cis = null;
        try {
            is = new FileInputStream(srcFileName);
            out = new FileOutputStream(destFileName);
            SecretKey deskey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), ENCRYPT_TYPE);
            Cipher cipher = Cipher.getInstance(ENCRYPT_TYPE);
            cipher.init(Cipher.ENCRYPT_MODE, deskey);
            // 创建加密流
            cis = new CipherInputStream(is, cipher);
            byte[] buffer = new byte[100];
            int r;
            while ((r = cis.read(buffer)) > 0) {
                out.write(buffer, 0, r);
            }
            System.out.println("文件" + srcFileName + "加密完成，加密后的文件是:" + destFileName);
            return true;
        } catch (Exception e) {
            System.out.println("加密文件" + srcFileName + "出现异常");
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (cis != null) {cis.close();}
            } catch (IOException e) {}
            try {
                if (is != null) {is.close();}
            } catch (IOException e) {}
            try {
                if (out != null) {out.close();}
            } catch (IOException e) {}
        }
    }

    /**
     * 解密文件
     * @param srcFileName  要解密的文件
     * @param destFileName 解密后存放的文件名
     */
    public boolean decryptFile(String srcFileName, String destFileName) {
        InputStream is = null;
        OutputStream out = null;
        CipherOutputStream cos = null;
        try {
            is = new FileInputStream(srcFileName);
            out = new FileOutputStream(destFileName);
            SecretKey deskey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), ENCRYPT_TYPE);
            Cipher cipher = Cipher.getInstance(ENCRYPT_TYPE);
            cipher.init(Cipher.DECRYPT_MODE, deskey);
            // 创建解密流
            cos = new CipherOutputStream(out, cipher);
            byte[] buffer = new byte[512 * 1024];
            int r;
            while ((r = is.read(buffer)) > 0) {
                cos.write(buffer, 0, r);
            }
            System.out.println("文件" + srcFileName + "解密完成，解密后的文件是:" + destFileName);
            return true;
        } catch (Exception e) {
            System.out.println("解密文件" + srcFileName + "出现异常");
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (cos != null) {cos.close();}
            } catch (IOException e) {}
            try {
                if (is != null) {is.close();}
            } catch (IOException e) {}
            try {
                if (out != null) {out.close();}
            } catch (IOException e) {}
        }
    }

    /***
     * 测试加密解密
     * @param args
     */
    public static void main(String[] args) {
        String filePath = "/Users/demussong/Desktop/local/test.txt";
        String encryptPath = "/Users/demussong/Desktop/local/test2enc.txt";
        String decryptPath = "/Users/demussong/Desktop/local/test2dec.txt";
        CipherFile deEncrypt = new CipherFile();
        // 加密
        deEncrypt.encryptFile(filePath, encryptPath);
        // 解密
        deEncrypt.decryptFile(encryptPath, decryptPath);
    }
}
