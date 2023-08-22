package com.demussong.fileinfo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.List;


public class FileAttributeTest {

    public static void main(String [] args) throws Exception {

        String filePath = "/Users/demussong/Desktop/local/a.txt"; //指定文件路径
        writeUserDefinedAttribute(filePath);
        readUserDefinedAttribute(filePath);
        listUserDefinedAttributes(filePath);

    }

    static void writeUserDefinedAttribute(String filePath) throws IOException {

        Path path = Paths.get(filePath);
        UserDefinedFileAttributeView view = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);

        // 返回值表示写入了多少个字节
        int writeBytes = view.write("key3", Charset.defaultCharset().encode("value3"));
        System.out.println("write bytes:" + writeBytes);
    }

    static void readUserDefinedAttribute(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        UserDefinedFileAttributeView view = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
        String name = "key3";
        ByteBuffer buf = ByteBuffer.allocate(view.size(name));
        int readBytes = view.read(name, buf);
        System.out.println("read bytes:" + readBytes);
        buf.flip();
        String value = Charset.defaultCharset().decode(buf).toString();
        System.out.println("value=" + value);
    }

    // 列出属性所有key/value
    static void listUserDefinedAttributes(String filePath) throws IOException{
        Path path = Paths.get(filePath);
        UserDefinedFileAttributeView view = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
        List<String> attrNames = view.list();
        for (String name : attrNames) {
            ByteBuffer bb = ByteBuffer.allocate(view.size(name)); // 准备一块儿内存块读取
            view.read(name, bb);
            bb.flip();
            String value = Charset.defaultCharset().decode(bb).toString();
            System.out.println(name + " : " + value);
        }
    }

}
