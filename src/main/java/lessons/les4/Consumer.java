package lessons.les4;

public class Consumer extends Thread implements Runnable{

    Store s;

    Consumer(Store s){
        this.s = s;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            s.get();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
