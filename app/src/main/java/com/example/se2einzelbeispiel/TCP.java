package com.example.se2einzelbeispiel;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCP implements Runnable {

    String sentence;
    TCP(String sentence) {
        this.sentence = sentence;
    }

    String modifiedSentence;


    @Override
    public void run() {

        if (sentence != null) {

            try {

                //create client socket, connect to server
                Socket clientSocket = new Socket("se2-isys.aau.at", 53212);

                //create output stream attached to socket
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

                //create input stream attached to socket
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                //send line to server
                outToServer.writeBytes(sentence + '\n');

                //read line from server
                modifiedSentence = inFromServer.readLine();

                System.out.println("From Server: " + modifiedSentence);

                clientSocket.close();

            } catch (Exception e) {

                e.printStackTrace();
                System.out.println("Es wurde kein Inhalt gefunden.");

            }
        }
    }



}
