package Lesson4_HomeWork;

public class Multithreading_I {
    public static void main(String[] args) {
        new Thread(new WriteThread1()).start();
        new Thread(new WriteThread2()).start();
        new Thread(new WriteThread3()).start();
    }

}
