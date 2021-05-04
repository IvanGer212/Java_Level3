package Lesson5_HomeWork;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT+1);
        //CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2);
        StarterCyclicBarier starterCyclicBarier = new StarterCyclicBarier(cyclicBarrier);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT/2), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10),countDownLatch, cyclicBarrier);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        starterCyclicBarier.startCyclicBarier(cyclicBarrier);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        starterCyclicBarier.startCyclicBarier(cyclicBarrier);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        race.clearWinnerCounter();

    }
}