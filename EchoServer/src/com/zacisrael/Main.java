package com.zacisrael;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        // write your code here
        try (ServerSocket serverSocket = new ServerSocket(5000)) {



            while (true) {
                // Kicking off a new Thread every time we start a connection
                // Prevents thread interference
                new Echoer(serverSocket.accept()).start();
            }


        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
        }
    }
}
