package com.zacisrael;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {
    /* What is a Datagram packet?
        Datagram packets are used to implement a connectionless packet delivery service.
        Each message is routed from one machine to another based solely on information
        contained within that packet. Multiple packets sent from one machine to another might
        be routed differently, and might arrive in any order.

        What is a Datagram socket?
        A datagram socket is the sending or receiving point for a packet delivery service.
        Each packet sent or received on a datagram socket is individually addressed and routed.
        In some implementations, broadcast packets may also be received when a DatagramSocket is
        bound to a more specific address.


    */

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();  // getByName()
            DatagramSocket datagramSocket = new DatagramSocket();

            Scanner scanner = new Scanner(System.in);
            String echoString;

            do {
                System.out.println("Enter string to be echoed: " );
                echoString = scanner.nextLine();

                byte[] buffer = echoString.getBytes();

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
                datagramSocket.send(packet);

                byte[] buffer2 = new byte[50];
                packet = new DatagramPacket(buffer2, buffer2.length);
                datagramSocket.receive(packet);
                System.out.println("Text received is: " + new String(buffer2, 0, packet.getLength()));

            } while(!echoString.equals("exit"));

        } catch(SocketTimeoutException e) {
            System.out.println("The socket timed out");
        } catch(IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
//    public static void main(String[] args) {
//
//        try{
//            InetAddress address = InetAddress.getLocalHost();
//            // getting the address of the host that we would like to send data to
//
//            DatagramSocket datagramSocket = new DatagramSocket();
//            Scanner scanner = new Scanner(System.in);
//            String echoString;
//
//            do{
//                System.out.println("Enter string to be echoed: ");
//                echoString = scanner.nextLine();
//                // Getting input from user
//
//                byte[] buffer = echoString.getBytes();
//                // Converting user input to a byte array
//
//                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
//                datagramSocket.send(packet);
//
//                byte[] buffer2 = new byte[50];
//                packet = new DatagramPacket(buffer2, buffer2.length);
//                datagramSocket.receive(packet);
//                System.out.println("Text received is: " + new String(buffer2, 0, packet.getLength()));
//
//            } while(!echoString.equals("exit"));
//
//        } catch (SocketTimeoutException e){
//            System.out.println("Socket timed out.");
//        }  catch (IOException e){
//            System.out.println("IOException");
//        }
//    }
}
