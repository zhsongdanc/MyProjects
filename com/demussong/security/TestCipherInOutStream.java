package com.demussong.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/2/8 20:37
 */
public class TestCipherInOutStream {

    public static void main(String[] args) {
        testInAndOut();
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
            cipher.init(Cipher.ENCRYPT_MODE, deskey);

            in = new FileInputStream(new File(srcPath));
            cis = new CipherInputStream(in, cipher);
            out = new FileOutputStream(new File(destPath));
            cos = new CipherOutputStream(out, cipher);

            byte[] buffer = new byte[256];
            int i = 0;
            while ((i = cis.read(buffer)) != -1){
                System.out.println("i=" + i);
                cipher.init(Cipher.DECRYPT_MODE, deskey);
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
