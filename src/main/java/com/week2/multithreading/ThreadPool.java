package com.week2.multithreading;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool{
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3); // Create a thread pool with 3 threads

        Runnable task1 = () -> {
            System.out.println("Executing Task 1");
        };

        Runnable task2 = () -> {
            System.out.println("Executing Task 2");
        };

        Runnable task3 = () -> {
            System.out.println("Executing Task 3");
        };

        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);

        executor.shutdown(); // Shutdown the executor
    }
}
