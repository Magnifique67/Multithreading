package com.week2.multithreading;


class Counter {
    private int count = 0;

    public void increment() {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " is incrementing. Current count: " + count);
            count++;

            System.out.println(Thread.currentThread().getName() + " has incremented. New count: " + count);

        }
    }

    public int getCount() {
        return count;
    }
}

public class BlockSynchronization {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i <5; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + counter.getCount());
    }
}
