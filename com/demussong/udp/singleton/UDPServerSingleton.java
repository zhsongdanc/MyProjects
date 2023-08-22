package com.demussong.udp.singleton;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/*
 * @Author: demussong
 * @Description:
 * 缺点：
 * 1。 服务端只能接受一个客户端的请求
 * 2。 如果发送或接收的数据大于一个字节数组的长度，则不能用了
 * @Date: 2023/4/7 10:18
 */
public class UDPServerSingleton {

    public static void main(String[] args){
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(12431);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0 ,bytes.length);
        System.out.println("等待客户端的连接：");
        try {
            datagramSocket.receive(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String req = new String(bytes, 0, datagramPacket.getLength());
        System.out.println("来自客户端的请求：" + req);

        String resp = "Hello, Client！";
        byte[] respBytes = resp.getBytes(StandardCharsets.UTF_8);
        DatagramPacket datagramPacket1 = new DatagramPacket(respBytes, 0, respBytes.length, datagramPacket.getAddress(), datagramPacket.getPort());
        try {
            datagramSocket.send(datagramPacket1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


