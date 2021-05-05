package Lesson5_HomeWork;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class StarterCyclicBarier {
    CyclicBarrier cyclicBarrier;

    public StarterCyclicBarier(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void startCyclicBarier(CyclicBarrier cyclicBarrier){
        cyclicBarrier.reset();
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
