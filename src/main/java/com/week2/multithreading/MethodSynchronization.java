package com.week2.multithreading;

class Method {
    private int count = 0;

    public synchronized void increment() {

        System.out.println(Thread.currentThread().getName() + " is incrementing. Current count: " + count);
        count++;

        System.out.println(Thread.currentThread().getName() + " has incremented. New count: " + count);
    }

    public int getCount() {
        return count;
    }
}

public class MethodSynchronization {
    public static void main(String[] args) throws InterruptedException {
        Method method = new Method();

        Runnable task = () -> {
            for (int i = 0; i < 10; i++) {
                method.increment();
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + method.getCount());
    }
}
