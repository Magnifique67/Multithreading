package com.week2.multithreading;
class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Thread is in Runnable state.");
            Thread.sleep(1000); // Thread is now in Timed Waiting state
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted.");
        }
        System.out.println("Thread has finished executing and is now Terminated.");
    }
}


public class RunnableApplication {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}

