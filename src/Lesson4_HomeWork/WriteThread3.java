package Lesson4_HomeWork;

public class WriteThread3 implements Runnable{
    private Data data;

    public WriteThread3(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        data.writeLetterC();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
