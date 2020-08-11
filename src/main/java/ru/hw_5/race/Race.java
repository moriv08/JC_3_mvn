package ru.hw_5.race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Race {


    public static AtomicInteger checkPoints; // счетчик пройденных дорог
    public static int rounds = 0; // how many rounds

    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        checkPoints = new AtomicInteger(stages.length * MainClass.CARS_COUNT);  // количество контрольных точек (дороги умноженные на колличество машин)
        this.rounds = stages.length;
    }

    public static boolean getFinish(){
        return (checkPoints.get() == 0) ? true : false; // метод возвращает true когда все машины проедут все контрольные точек
    }
}