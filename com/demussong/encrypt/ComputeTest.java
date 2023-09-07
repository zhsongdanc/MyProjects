package com.demussong.encrypt;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/8/29 20:47
 */
public class ComputeTest {

    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        list.add(4095L);
        list.add((long)4095*3+1);
        List<Long> cipherChunkLenLst = getCipherChunkLenLst(4095, list);
        for (Long aLong : cipherChunkLenLst) {
            System.out.println(aLong);
        }
        System.out.println(compute2((long) 4095*3+1,4095));
    }


    public static List<Long> getCipherChunkLenLst(int encryptSegLength,List<Long> plainChunkLenLst){

        List<Long> tmpLenLst=new ArrayList<>();
        plainChunkLenLst.stream().reduce(0l,(a,b)->{
            long currLen=b-a;

            int mod=(int) (currLen%encryptSegLength);
            int calNum=16-encryptSegLength%16;
            int paddingSize=0;
            if(mod>0) {
                paddingSize=16-mod%16;
            }
            long tmpCipherLen=currLen+(currLen-mod)/encryptSegLength*calNum+paddingSize;
            if(tmpLenLst.size()>0) {
                tmpLenLst.add(tmpCipherLen+tmpLenLst.get(tmpLenLst.size()-1));
            }else {
                tmpLenLst.add(tmpCipherLen);
            }
            return b;
        },(a,b)->0l);
        return tmpLenLst;
    }
    public static long compute2(long plainLength,int encryptSegLength) {


        long mod = plainLength % encryptSegLength;

        int calNum=16-encryptSegLength%16;
        int paddingSize=0;
        if(mod>0) {//多余的字节数和16求余，获取需要填充的字节数
            paddingSize=(int) (16-mod%16);
        }
        return   plainLength + (long) (plainLength / encryptSegLength)*calNum+paddingSize ;

    }

}
