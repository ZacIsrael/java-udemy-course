package com.zacisrael;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try(Socket socket = new Socket("localhost", 5000)) {

            socket.setSoTimeout(5000); // 5 second timeout

            BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            do {
                System.out.println("Enter string to be echoed: ");
                echoString = scanner.nextLine(); // user input

                stringToEcho.println(echoString); // sending string to the server
                if (!echoString.equals("exit")) {
                    response = echoes.readLine(); // reading the data coming back from the server
                    System.out.println(response);
                }

            } while (!echoString.equals("exit"));
        } catch (SocketTimeoutException e){
            System.out.println("The socket timed out.");
        } catch (IOException e){
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
