package ru.hw_3.client;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TextSender {

    public static void main(String[] args) {
        Socket socket = null;
//        Scanner in;
        DataOutputStream out;
        FileInputStream file;

        try {
            socket = new Socket("localhost", 8189);
            out = new DataOutputStream(socket.getOutputStream());
//            in = new Scanner(System.in);

            file = new FileInputStream("files/texts/book.txt");

            int x;
            while ((x = file.read()) != -1)
                out.write(x);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
