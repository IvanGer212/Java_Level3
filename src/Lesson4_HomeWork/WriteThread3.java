package Lesson4_HomeWork;

public class WriteThread3 implements Runnable{
    private final Data data = new Data();
    @Override
    public void run() {
        for (int i =0; i<5; i++){
            data.writeLetterC();
        }
        /**
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
