package ru.hw_5.race;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {

            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
            c.round++;

            Race.checkPoints.decrementAndGet(); // пройденная контрольная точка

            synchronized (this) {
                if ((c.round == Race.rounds) && !Car.isWinner.get()) {
                    System.err.println(c.getName() + " WIN"); // победитель
                    Car.isWinner.set(true);
                    Car.winner = c;
                }
            }

            c.time = System.currentTimeMillis();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}