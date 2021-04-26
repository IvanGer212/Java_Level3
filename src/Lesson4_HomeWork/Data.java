package Lesson4_HomeWork;

public class Data {
    private final Object mon = new Object();
    /**
     * 0 - Первый поток пишет букву
     * 1 - Второй поток пишет букву
     * 2 - Третий поток пишет букву
     */
    private byte queue = 0;

    public void writeLetterA(){
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (queue != 0){
                        mon.wait();
                    }
                    queue = 1;
                    System.out.print('A');
                    mon.notifyAll();
                }
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void writeLetterB(){
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (queue != 1){
                        mon.wait();
                    }
                    queue = 2;
                    System.out.print('B');
                    mon.notifyAll();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeLetterC() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (queue != 2) {
                        mon.wait();
                    }
                    queue = 0;
                    System.out.print('C');
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
