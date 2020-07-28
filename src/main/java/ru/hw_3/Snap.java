package ru.hw_3;

import java.io.*;

public class Snap {
    public static void main(String[] args) throws IOException {
        File file = new File("files/texts");

//        file.mkdirs();
//        String[] text = file.list((dir, name) -> name.startsWith("t"));
//        for (String s: text) {System.out.println(s);}

//        File file1 = new File("txt.txt");

        int i = 0;

        try(FileInputStream input = new FileInputStream("files/texts/text.txt");
            FileOutputStream out = new FileOutputStream("files/txt.txt")){

            int x;
            while ((x = input.read()) != -1){

//                out.write((char) x);
//                System.out.print((char) x);


            }
        }catch (FileNotFoundException e){

        }catch (IOException e){

        }

    }
}
