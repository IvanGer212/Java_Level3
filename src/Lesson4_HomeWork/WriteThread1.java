package Lesson4_HomeWork;

public class WriteThread1 implements Runnable{
    private  Data data;

    public WriteThread1(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        data.writeLetterA();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
