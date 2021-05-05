package Lesson4_HomeWork;

public class Multithreading_I {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(new WriteThread1(data)).start();
        new Thread(new WriteThread2(data)).start();
        new Thread(new WriteThread3(data)).start();
    }

}
