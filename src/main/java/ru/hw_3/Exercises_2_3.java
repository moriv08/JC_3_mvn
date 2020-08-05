package ru.hw_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class Exercises_2_3 {
    public static void main(String[] args) {

        // 1. Exercise
        byte[] arr = new byte[50];
        int i = 0;

        try(FileInputStream input = new FileInputStream("files/texts/text.txt")){
            while (input.read(arr) != -1){
//                System.out.println(new String(arr));
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        while (i < 49)
            System.out.println(arr[i++]);

        // 2. Exercise
        SequenceInputStream in = null;
        try(FileOutputStream out = new FileOutputStream("files/texts/all.txt")){

            ArrayList<InputStream> all = new ArrayList<>();
            all.add(new FileInputStream("files/texts/1.txt"));
            all.add(new FileInputStream("files/texts/2.txt"));
            all.add(new FileInputStream("files/texts/3.txt"));
            all.add(new FileInputStream("files/texts/4.txt"));
            all.add(new FileInputStream("files/texts/5.txt"));

            in = new SequenceInputStream(Collections.enumeration(all));

            int x;
            while ((x = in.read()) != -1)
                out.write(x);

//            Enumeration<InputStream> in2 = Collections.enumeration(all);
//
//            while (in2.hasMoreElements()){
//                int y;
//                if ((y = in2.nextElement().read()) != -1)
//                    System.out.println(y);
//                    out.write(y);
//            }



//        List<InputStream> all = new ArrayList<>();
//
//        try(FileInputStream in1 = new FileInputStream("files/texts/1.txt");
//            FileInputStream in2 = new FileInputStream("files/texts/2.txt");
//            FileInputStream in3 = new FileInputStream("files/texts/3.txt");
//            FileInputStream in4 = new FileInputStream("files/texts/4.txt");
//            FileInputStream in5 = new FileInputStream("files/texts/5.txt");
//
//            FileOutputStream out = new FileOutputStream("files/texts/all.txt")){
//
//            all.add(in1);
//            all.add(in2);
//            all.add(in3);
//            all.add(in4);
//            all.add(in5);
//
//            for (int j = 0; j < all.size(); j++) {
//                int x;
//                while ((x = all.get(j).read()) != -1){
//                    out.write(x);
//                }
//            }
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                in.close();
            }catch (IOException e){

            }
        }

    }
}
