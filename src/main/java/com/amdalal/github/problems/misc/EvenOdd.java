package com.amdalal.github.problems.misc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenOdd {
    public static void main(String[] args) {
        ExecutorService e = Executors.newFixedThreadPool(2);
        e.submit(new EvenOddWorker(false));
        e.submit(new EvenOddWorker(true));
    }
}

class EvenOddWorker implements Runnable {
    private static int          counter     = 0;
    private static boolean      evenPrinted = true;
    private static final Object lock        = new Object();
    private boolean             evenPrinter;

    public EvenOddWorker(boolean evenPrinter) {
        this.evenPrinter = evenPrinter;
    }

    @Override
    public void run() {
        if (evenPrinter) {
            printEven();
        } else {
            printOdd();
        }
    }

    private void printEven() {
        while (counter <= 100) {
            synchronized (lock) {
                if (!evenPrinted) {
                    System.out.println(Thread.currentThread().getName() + "|" + ++counter);
                    evenPrinted = true;
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void printOdd() {
        while (counter <= 100) {
            synchronized (lock) {
                if (evenPrinted) {
                    System.out.println(Thread.currentThread().getName() + "|" + ++counter);
                    evenPrinted = false;
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}