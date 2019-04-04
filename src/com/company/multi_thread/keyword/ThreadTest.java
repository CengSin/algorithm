package com.company.multi_thread.keyword;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest {
//    volatile boolean running = true;
    int i = 0;

    public void test() {
        new Thread(new Runnable() {
            public void run() {
                int counter = 0;
                while (i == 0) {
//                    i++;
//                    System.out.println("Thread 1 is Running? " + running);
                    counter++;
                }
//                System.out.println("Thread 1 is Running? " + running);
                System.out.println("Thread 1 finished. Counted up to " + counter);


            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                // Sleep for a bit so that thread 1 has a chance to start
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                    // catch block
                }
                System.out.println("Thread 2 finishing");
//                running = false;
                i = 1;
            }
        }).start();
    }

    public static void main(String[] args) {
//        new ThreadTest().test();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.parallelStream().forEach( i -> System.out.println(Thread.currentThread().getName()));
    }
}