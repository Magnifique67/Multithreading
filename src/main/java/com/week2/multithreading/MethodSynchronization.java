package com.week2.multithreading;

class Method {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class MethodSynchronization {
    public static void main(String[] args) throws InterruptedException {
        Method method = new Method();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                method.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + method.getCount());
    }
}
