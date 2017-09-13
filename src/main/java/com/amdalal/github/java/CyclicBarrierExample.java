package com.amdalal.github.java;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    private static CyclicBarrier barrier = new CyclicBarrier(4, null);

    public static void main(String[] args) {
        new Thread(new Worker(barrier)).start();
        new Thread(new Worker(barrier)).start();
        new Thread(new Worker(barrier)).start();
        new Thread(new Worker(barrier)).start();
        new Thread(new Worker(barrier)).start();
        new Thread(new Worker(barrier)).start();
    }

    static class BarrierAction implements Runnable {
        @Override
        public void run() {
            System.out.println("in BarrierAction#run()");
        }
    }

    static class Worker implements Runnable {

        private CyclicBarrier barrier;

        public Worker(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " | awaiting()");
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " | after await()");
        }
    }
}
