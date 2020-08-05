package lessons.les4;

public class Store {
    int store = 0;

    public synchronized void get(){
        while (store < 1){
            try {
                System.out.println("Costomer is waiting...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        store++;
        System.out.println("took one");
        notify();
    }

    public synchronized void put(){
        while (store >= 3){
            try {
                System.out.println("Produser is waiting...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        store++;
        System.out.println("add one");
        notify();
    }
}
