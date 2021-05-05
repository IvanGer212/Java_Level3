package Lesson4_HomeWork;

public class WriteThread2 implements Runnable{
    private Data data;

    public WriteThread2(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        data.writeLetterB();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
