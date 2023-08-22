package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UncheckedIOException;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/2/10 17:30
 */
public class TestCatchThrow {

    public static void main(String[] args) {
        System.out.println(1);
        try{
            FileInputStream inputStream = new FileInputStream("/fw/wef");
        }catch (IOException e){
            throw new UncheckedIOException(e);
        }

        System.out.println(2);
    }
}
