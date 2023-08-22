package com.demussong.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/4/7 10:22
 */
public class UDPClient {

    public static void main(String[] args){
        // 发送
        InetAddress localHost = null;
        try {
            localHost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        String msg = "Server, hello!";
        byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0 , bytes.length, localHost, 12431);

        try {
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // 接收
        byte[] buffer = new byte[1024];
        DatagramPacket receive = new DatagramPacket(buffer, 0, buffer.length);
        try {
            datagramSocket.receive(receive);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String reply = new String(buffer, 0, receive.getLength());
        System.out.println("客户端收到消息；" + reply);
    }
}
