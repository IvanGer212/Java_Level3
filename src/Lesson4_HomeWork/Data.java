package Lesson4_HomeWork;

public class Data {
    private char letter;
    /**
     * 0 - Первый поток пишет букву
     * 1 - Второй поток пишет букву
     * 2 - Третий поток пишет букву
     */
    private byte queue = 0;

    public synchronized void writeLetterA(){
        while (queue!=0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue = 1;
        System.out.print('A');
        notifyAll();
    }

    public synchronized void writeLetterB(){
        while (queue!=1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue = 2;
        System.out.print('B');
        notifyAll();
    }

    public synchronized void writeLetterC(){
        while (queue!=2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue = 0;
        System.out.print('C');
        notifyAll();
    }

}
