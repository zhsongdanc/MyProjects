package com.demussong.security;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

/*
 * @Author: demussong
 * @Description: fileservice-decrypt
 * @Date: 2022/8/24 14:49
 */
public class Test3 {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "/Users/demussong/Desktop/local/wordTest2.pdf";
        String encryptPath = "/Users/demussong/Desktop/0011en.pdf";
        String decryptPath = "/Users/demussong/Desktop/0011de.pdf";



        String encryptPathDoc = "/Users/demussong/Documents/1223.pdf";
        String decryptPathDoc = "/Users/demussong/Documents/1223de.pdf";


        String xlsxen = "/Users/demussong/Desktop/456.pdf";
        String xlsde = "/Users/demussong/Desktop/456de.pdf";

        String ENCRYPT_TYPE = "AES";
        // 加密秘钥，长度为24字节
//        String ENCRYPT_KEY = "hwTG83wc4yH4Zb4VLo+Cl4v/aJBAiKWEfzmz+WfBhFI=";
        String xlskey = "s6EbUwPrBDMkHgJ4YjdW0kZ9VHMxD9Hnc/KstZdz9YI=";
        String ENCRYPT_KEY = "ALl+0t+Y6IQ7ui2ExcNJujKkrpGzLBD1fcPKQB6gp9M=";
//        String ENCRYPT_KEY = "+LZgH6lBgbfWd/obMMUlGDafqSyXQHcjoYp0k8yxHts=";

//        encrypt(ENCRYPT_TYPE, "krOP8WBjgigNKUzcsDw8yDYVCbG+I+6f1LePYPJxv7o=", "/Users/demussong/Desktop/testXLSX.xlsx",
//                "/Users/demussong/Desktop/testXLSXcopy2.xlsx");

        //用于测试附件解密
//        decrypt(ENCRYPT_TYPE, "paoEVxFUkM2kkWwKLB3YR64jE6ozonObaFiXgrH7mrc=", encryptPath, decryptPath);
        decrypt(ENCRYPT_TYPE, "/dLFZSkhTb2VxFH/asKzGvrw13kI5ZvSvD81nWFeghE=", encryptPath, decryptPath);

//        byte[] bytes = Base64.getDecoder().decode("+LZgH6lBgbfWd/obMMUlGDafqSyXQHcjoYp0k8yxHts=");
//        System.out.println(new String(bytes));
//        byte[] bytes = {-8, -74, 96, 31, -87, 65, -127, -73, -42, 119, -6, 27, 48, -59, 37, 24, 54, -97, -87, 44, -105, 64, 119, 35, -95, -118, 116, -109, -52, -79, 30, -37};
//        byte[] decode = Base64.getDecoder().decode("CImCmnofgxVbbl9++P/r+4gj0HuUv5tzQBzZwCwuWGw=");
//        for (int i = 0; i < decode.length; i++) {
//            System.out.println(byteToInt(bytes[i]));
//        }

    }



    public static void encrypt(String type, String key, String srcPath, String destPath) {
        InputStream in = null;
        CipherInputStream cis = null;
        OutputStream out = null;
        try{
            byte[] bytes = Base64.getDecoder().decode(key);
            System.out.println(new String(bytes));

            SecretKey deskey = new SecretKeySpec(bytes, type);
            Cipher cipher = Cipher.getInstance(type);
            cipher.init(Cipher.ENCRYPT_MODE, deskey);

            in = new FileInputStream(new File(srcPath));
            cis = new CipherInputStream(in, cipher);
            out = new FileOutputStream(new File(destPath));

            byte[] buffer = new byte[256];
            int i = 0;
            while ((i = cis.read(buffer)) != -1){
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
            byte[] bytes = Base64.getDecoder().decode(key);
            System.out.println(new String(bytes));

            SecretKey deskey = new SecretKeySpec(bytes, type);
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

    public static int byteToInt(byte b) {
        //Java 总是把 byte 当做有符处理；我们可以通过将其和 0xFF 进行二进制与得到它的无符值
        return b & 0xFF;
    }



    static void testInAndOut() {

        String type = "AES";
        String key = "7f2nn18H3DkTELknx7jS674XTesZ3gDW2dbTemI8a2M=";
//        decrypt(ENCRYPT_TYPE, "7f2nn18H3DkTELknx7jS674XTesZ3gDW2dbTemI8a2M=", encryptPath, decryptPath);
        String srcPath = "/Users/demussong/Desktop/testXLSX.xlsx";
        String destPath = "/Users/demussong/Desktop/testXLSXcopy1.xlsx";


        InputStream in = null;
        OutputStream out = null;
        CipherInputStream cis = null;
        CipherOutputStream cos = null;
        try{
            byte[] bytes = Base64.getDecoder().decode(key);
            System.out.println(new String(bytes));

            SecretKey deskey = new SecretKeySpec(bytes, type);
            System.out.println("key=" + deskey.toString());

            Cipher cipher = Cipher.getInstance(type);
            cipher.init(Cipher.DECRYPT_MODE, deskey);

            in = new FileInputStream(new File(srcPath));
            cis = new CipherInputStream(in, cipher);
            out = new FileOutputStream(new File(destPath));
            cos = new CipherOutputStream(out, cipher);

            byte[] buffer = new byte[256];
            int i = 0;
            while ((i = cis.read(buffer)) != -1){
                cos.write(buffer, 0 , i);
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
                if (in != null) {in.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
