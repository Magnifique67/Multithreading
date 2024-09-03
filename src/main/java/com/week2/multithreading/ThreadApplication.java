package com.week2.multithreading;
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running using Thread class.");
    }
}

public class ThreadApplication {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
