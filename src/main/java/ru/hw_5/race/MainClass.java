package ru.hw_5.race;

import java.util.concurrent.*;

public class MainClass {

    static boolean start = false;

    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(40), new Tunnel(CARS_COUNT / 2, 80), new Road(60), new Tunnel(CARS_COUNT / 4, 50));
        Car[] cars = new Car[CARS_COUNT];

        CyclicBarrier barrier = new CyclicBarrier(CARS_COUNT + 1);


        for (int i = 0; i < cars.length; i++)
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), barrier);

        for (int i = 0; i < cars.length; i++)
            new Thread(cars[i]).start();


        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        start = true;

        while (!Race.getFinish())
            continue;

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");

        Car.theWinner(cars);
    }
}

