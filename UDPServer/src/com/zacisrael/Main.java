package com.zacisrael;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Main {
    /*  What is UDP?
   The UDP protocol provides a mode of network communication whereby
   applications send packets of data, called datagrams, to one another.
   The DatagramPacket and DatagramSocket classes in the java.net package
    implement system-independent datagram communication using UDP.

    What is TCP?
    TCP stands for Transmission Control Protocol, which allows for reliable communication
    between two applications. TCP is typically used over the Internet Protocol,
     which is referred to as TCP/IP.


    What is the difference between TCP & UDP?
    TCP is a connection-oriented protocol and it implements a connection
     as a stream of bytes from source to destination, while UDP is a connectionless
     transport protocol and uses datagrams to implement its communication.
     The Java socket API provides the basis of TCP/UDP communication.

    * */

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(5000);

            while(true) {
                byte[] buffer = new byte[50];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                System.out.println("Text received is: " + new String(buffer, 0, packet.getLength()));

                String returnString = "echo: " + new String(buffer, 0, packet.getLength());
                byte[] buffer2 = returnString.getBytes();
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buffer2, buffer2.length, address, port);
                socket.send(packet);
            }

        } catch(SocketException e) {
            System.out.println("SocketException: " + e.getMessage());
        } catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }


//    public static void main(String[] args) {
//
//        try{
//            DatagramSocket socket = new DatagramSocket(5000);
//
//            while (true){
//                byte[] buffer = new byte[50];
//                // byte array that accepts data from the socket
//
//                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
//                // will be populated with whatever is received from the socket
//
//                socket.receive(packet);
//                // fills the packet with the content
//
//                System.out.println("Text received is: " + new String(buffer,0, packet.getLength()));
//
//                String returnString = "echo: " + new String(buffer, 0, packet.getLength());
//                byte[] buffer2 = returnString.getBytes();
//                InetAddress address = packet.getAddress();
//                int port = packet.getPort();
//                packet = new DatagramPacket(buffer2, buffer2.length, address, port);
//                socket.send(packet);
//
//            }
//        } catch (SocketException e){
//            System.out.println("SocketException: " + e.getMessage());
//        } catch (IOException e){
//            System.out.println("IOException: " + e.getMessage());
//        }
//    }
}
