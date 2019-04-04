package com.company.multi_thread.z;
/**
 * 多线程同时对一个变量进行操作
 */
public class MyRunnable_1 implements Runnable {
    private int count = 5;

    /**
     * 在添加了synchronized之后，cpu执行线程时会用队列的方式来运行run方法中的代码，
     * 在执行run之前会判断run是否被上锁，如果被上锁了，就会进入等待其他线程对run方法执行完毕，
     * 再对run执行
     */
    @Override
    synchronized public void run() {
        /**
         * 多线程共享代码块,卖票问题,最好不要再多线程代码中使用循环
         */
        count--;
        System.out.println("count=" + count);
    }

    public static void main(String[] args) {
        MyRunnable_1 myRunnable_1 = new MyRunnable_1(); // 线程代码对象
        Thread thread = new Thread(myRunnable_1);   // 线程1
        Thread thread1 = new Thread(myRunnable_1);  // 线程2
        Thread thread2 = new Thread(myRunnable_1);  // 线程3
        thread.start();
        thread1.start();
        thread2.start();
    }
}
