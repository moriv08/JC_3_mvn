package ru.hw_3.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket server = null;
    private Socket socket = null;
    private DataOutputStream out;
    private DataInputStream in;
    private FileOutputStream file;

    Server(){


        try {

            server = new ServerSocket(8189);
            System.out.println("Server started...");

            try {
                socket = server.accept();
                System.out.println("Client connected");

                in = new DataInputStream(socket.getInputStream());

                writeToFile("files/texts/fromServer.txt");

            }catch (IOException e){

            }


        }catch (IOException e){
        e.printStackTrace();
        }finally {
            try{
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            try{
                server.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void writeToFile(String file) throws IOException{
        this.file = new FileOutputStream(file);

        int x;
        while ((x = in.read()) != -1)
            this.file.write(x);
    }

}
