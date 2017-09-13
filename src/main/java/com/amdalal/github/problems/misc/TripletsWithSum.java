package com.amdalal.github.problems.misc;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TripletsWithSum {

    private ConcurrentMap<Integer, Wrapper> state = new ConcurrentHashMap<>();

    private ExecutorService                 e     = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        int i = 2;
        while (true) {
            i = i * i;
            System.out.println(i);
        }
    }

    private enum Action {
        KILL,
        SLEEP,
        STATUS_CHECK
    }

    private static class Wrapper {
        Thread thread;
        long   sleepTime;

        public Wrapper(Thread t, long sleepTime) {
            this.thread = t;
            this.sleepTime = sleepTime;
        }
    }

    private class ActionImpl implements Runnable {
        private Action  action;
        private Integer connectionId;
        private Integer timeout;

        public ActionImpl(Action action, Integer connectionId, Integer timeout) {
            this.action = action;
            this.connectionId = connectionId;
            this.timeout = timeout;
        }

        @Override
        public void run() {
            switch (action) {
                case KILL:
                    System.out.println(Thread.currentThread().getName() + "| " + "Killing connection id " + connectionId);
                    state.get(connectionId).thread.interrupt();
                    state.remove(connectionId);
                    System.out.println(Thread.currentThread().getName() + "| " + "Killed connection id " + connectionId);
                    break;
                case SLEEP:
                    System.out.println(Thread.currentThread().getName() + "| " + "Sleeping for " + timeout + " ms");
                    state.put(connectionId, new Wrapper(Thread.currentThread(), System.currentTimeMillis()));
                    try {
                        Thread.sleep(timeout);
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + "| " + "Interrupted :(");
                    }
                    break;
                case STATUS_CHECK:
                    System.out.println(Thread.currentThread().getName() + "| " + "Returning status");
                    state.forEach((k, v) -> {
                        System.out.println(Thread.currentThread().getName() + "| " + k + "|" + (System.currentTimeMillis() - v.sleepTime));
                    });
                    break;
            }
        }
    }
}
