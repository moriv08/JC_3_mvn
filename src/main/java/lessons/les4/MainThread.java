package lessons.les4;

import static java.lang.Thread.activeCount;
import static java.lang.Thread.sleep;

public class MainThread {
    public static int COUNT = 0;
    public int co = 0;
    public synchronized static void main(String[] args){

        Store s = new Store();
        Produser p = new Produser(s);
        Consumer c = new Consumer(s);

        p.start();
        c.start();


        // synchronized синхронизирует потоки. заставляет их выполняться последовательно
        // монитор создает синхронизацию. Ограничивает доступ к синхронизированному объекту
        // статичые объекты синхронизированны
        // синхронизированные и статичные методы
        // имутабельные типы данных и мутабельные. Integer  имутабельный
        // sleep(); усыпляет поток и держит объект синхронизации
        // wait(); усыпляет поток и отпускает объект синхронизации
        // notify(); возобновляет усыпленные потоки
        // volatile ... минуя кэш потока работает с переменной/ слово нужно, чтоб работать напрямую с объектом минуя кэш
        // synchronized сохраняет значение в кэш и синхронизирует объект
        // MFU принтер, сканер... многофуркциональные устройства

        Object obj = new Object();
        Object ob = new Object();

        new Thread(()->{
            synchronized (ob){
                System.out.println("OB");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj){
                    System.out.println("OBJ");
                }
            }

        }).start();

        Thread t = new Thread(()->{
            synchronized (obj){
                System.out.println("OBJ");
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (ob){
                    System.out.println("OB");
                }
            }

        });
        t.start();




//        ThreadClass tt = new ThreadClass();
//        ThreadClass b = new ThreadClass();
//        b.start();
//        t.start();

//        System.out.println(COUNT);
//        MainThread MainThread = new MainThread();
//
//        new Thread(()-> MainThread.print());





        while (!t.isAlive())
            System.out.println("End");
    }

    public void print(){
        MainThread m = new MainThread();
        for (int i = 0; i < 1000000000; i++) {
            m.co--;
            COUNT--;

        }
    }
}

class ThreadClass extends Thread {
    @Override
    public void run(){
        for (int i = 0; i < 1000000; i++){
            MainThread MainThread = new MainThread();
            MainThread.print();
        }
    }

}