package ru.hw_5.race;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

public class Car implements Runnable {

    private static int CARS_COUNT;
    CyclicBarrier barrier;
    public long time;
    public static AtomicBoolean isWinner = new AtomicBoolean(false);
    public int round;

    public static Car winner = null;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier barrier) {
        this.race = race;
        this.speed = speed;
        this.barrier = barrier;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.time = 0;
        this.round = 0;
    }

    @Override
    public void run() {

        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        while (!MainClass.start)
            continue;

        for (int i = 0; i < race.getStages().size(); i++)
            race.getStages().get(i).go(this);
    }

    public static void theWinner(Car[] cars){   // метод записывает участников в массив для простой распечатки

        for (int i = 1; i < cars.length - 1; i++) {
            if (cars[i] == winner){
                Car tmp = cars[0];
                cars[0] = winner;
                cars[i] = tmp;
                i = 0;
            }
            if (cars[i].time > cars[i + 1].time){
                Car tmp = cars[i + 1];
                cars[i + 1] = cars[i];
                cars[i] = tmp;
                i = 0;
            }
        }
        for (int i = 0; i < cars.length; i++)
            System.out.println((i + 1) + " место " + cars[i].getName() + " time " + (cars[i].time));

    }

}