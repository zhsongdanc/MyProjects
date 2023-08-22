package com.demussong.udp.multithread;

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
 * @Date: 2023/4/7 11:28
 */
public class UDPMultiThread {

    public static void main(String[] args) {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        int port = 12431;
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }


        while (true) {

            MultiThread multiThread = new MultiThread(datagramSocket);
            multiThread.start();
        }
    }
}

class MultiThread extends Thread{
    private DatagramSocket datagramSocket;

    public MultiThread(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    @Override
    public void run() {
        System.out.println("start--------");
        byte[] req = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(req, 0, req.length);
        try {
            datagramSocket.receive(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("from client:" + new String(req, 0, datagramPacket.getLength()));

        // reply
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
