package ru.hw_3;

import java.io.FileInputStream;
import java.io.IOException;

public class Exercise_3 {
    public static void main(String[] args) {

        try(FileInputStream file = new FileInputStream("files/texts/book.txt");){

            int i = 0;
            int x;
            while ((x = file.read()) != -1){
                System.out.print((char)x);
                if (++i > 1799) break;
            }
            System.out.println('\n' +
                    "Всего счинано символов " + i);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
