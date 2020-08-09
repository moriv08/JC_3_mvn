package ru.hw_3;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Exercise_3 {
    public static void main(String[] args) {

        try(FileInputStream file = new FileInputStream("files/texts/book.txt");){

            int PG_SIZE = 1800;
            Scanner scan = new Scanner(System.in);
            int i = -1;
            int x;
            int page = scan.nextInt() - 1;

            while ((x = file.read()) != -1)
                if (++i >= PG_SIZE * page)
                    System.out.print((char) x);


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
