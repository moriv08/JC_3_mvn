package ru.hw_5.race;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    public int width;
    public Semaphore semaphore;

    public Tunnel(int cars, int lenght) {
        this.width = cars;
        this.length = lenght;
        this.description = "Тоннель " + length + " метров";
        semaphore = new Semaphore(width);
    }

    @Override
    public void go(Car c) {
        try {

            try {

//                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getName() + " подъехал к тунелю: " + description);

                semaphore.acquire();
//                System.out.println(c.getName() + " начал этап: " + description);
                System.out.println(c.getName() + " въехал в тунель: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
//                System.out.println(c.getName() + " закончил этап: " + description);

                System.out.println(c.getName() + " выехал из тунеля: " + description);
                c.round++;

                Race.checkPoints.decrementAndGet(); // пройденная контрольная точка

                synchronized (this) {
                    if ((c.round == Race.rounds) && !Car.isWinner.get()) { // усли победителя еще нет и участник прошел все дороги и тоннели, он попадает в блок кода и аиксирует свою победу
//                        System.err.println("the winner is " + c.getName()); // победитель
                        Car.isWinner.set(true);
                        Car.winner = c;
                    }
                }

                c.time = System.currentTimeMillis();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}