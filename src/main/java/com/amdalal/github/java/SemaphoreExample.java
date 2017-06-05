package com.amdalal.github.java;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    private static Semaphore s = new Semaphore(5);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new Worker(s)).start();
        }
    }

    static class Worker implements Runnable {
        private Semaphore s;

        public Worker(Semaphore s) {
            this.s = s;
        }

        @Override
        public void run() {
            try {
                s.acquire();
                System.out.println(Thread.currentThread().getName() + " | Acquired");
                Thread.sleep(5000);
                s.release();
                System.out.println(Thread.currentThread().getName() + " | Released");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}