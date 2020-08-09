package ru.hw_4;

import org.w3c.dom.ls.LSOutput;

public class MFU {

    private final Object print = new Object();
    private final Object scan = new Object();

    public void print(String document){
        synchronized (print){
            System.out.println("Начало печати...");

            System.out.println(document);

            System.out.println("Конец печати.");
        }
    }

    public void scan(String document, boolean isNet){
        synchronized (scan){
            if (!isNet)
                synchronized (print){
                    System.out.println("Начало сканирования...");

                    System.out.println("Сканируем...");

                    System.out.println("Конец отсканированного документа");
                }
            else {
                System.out.println("Начало сканирования...");

                System.out.println("Сканируем...");

                System.out.println("Конец отсканированного документа");
            }
        }
    }

}
