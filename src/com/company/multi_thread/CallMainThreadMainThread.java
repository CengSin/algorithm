package com.company.multi_thread;

class MyThread extends Thread {

    @Override
    public synchronized void run() {
        super.run();
//        System.out.println("MyThread");
        /**
         * 验证线程的不确定性
         */
        for (int i = 0; i < 10; i++) {
            int time = (int) (Math.random() % 1000);
            try {
                Thread.sleep(time);
                System.out.println("test-" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class CallMainThreadMainThread {

    public static void main(String[] args) {
//        System.out.println(Thread.currentThread().getName());
//
//        MyThread myThread = new MyThread();
//        myThread.start();
//        System.out.print("Test-------");
        MyThread myThread=  new MyThread();
        myThread.setName("myThread");
        myThread.start();
        for (int i = 0; i< 10; i++) {
            try {
                Thread.sleep((long) (Math.random() % 1000));
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
