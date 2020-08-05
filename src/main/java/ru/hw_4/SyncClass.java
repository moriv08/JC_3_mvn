package ru.hw_4;

public class SyncClass {

    protected synchronized void printLetter(MyThread t){

            System.out.print(t.s);

        try {
            notifyAll();
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
