package com.demussong.paxosbasic;

import java.net.Inet4Address;
import java.net.InetAddress;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/4/6 16:52
 */
public class IPTest {

    public static void main(String[] args) throws Exception{
        System.out.println(InetAddress.getLocalHost().getHostName());
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        System.out.println(InetAddress.getLocalHost().getCanonicalHostName());
    }
}
