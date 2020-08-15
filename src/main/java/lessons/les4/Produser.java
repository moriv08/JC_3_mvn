package lessons.les4;

public class Produser extends Thread implements Runnable{

    Store s;

    Produser(Store s){
        this.s = s;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            s.put();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
