package ru.hw_4;

public class SyncClass {

    char curent = 'A';

    protected synchronized void printLetter(MyThread t){


        if (t.s != curent) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.print(t.s);

        if (curent == 'B')
            curent -= 2;
        else
            curent += 1;

        try {
            notifyAll();
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
