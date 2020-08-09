package ru.hw_4;

import static java.lang.Thread.sleep;

public class MainThread {
    public static void main(String[] args) {

        SyncClass sc = new SyncClass();

        MyThread a = new MyThread('A', sc);
        a.setPriority(10);

        MyThread b = new MyThread('B', sc);
        a.setPriority(9);

        MyThread c = new MyThread('C', sc);
        a.setPriority(8);

        a.start();
        b.start();
        c.start();

        try {
            a.join();
            b.join();
            c.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nend");
    }

}

class MyThread extends Thread{

    SyncClass sc;
    char s;

    MyThread(char s, SyncClass sc){
        this.s = s;
        this.sc = sc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            sc.printLetter(this);
        }
    }
}
