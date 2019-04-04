package com.company.multi_thread.sumNum;

public class MyThread extends Thread {

    private int i = 5;  // 多个线程共享同一个变量下出现的问题

    /**
     * 使用同步锁来避免
     */
    @Override
    synchronized public void run() {
        super.run();
        System.out.println("i = " + i-- +", Thread: " + Thread.currentThread().getName());
        // println()方法是线程安全（同步的），但是i--的操作实在进入println方法之前发生的，所以也会概率性的发生两个线程
        // 出现同一个数的情况
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(myThread);
        Thread t2 = new Thread(myThread);
        Thread t3 = new Thread(myThread);
        Thread t4 = new Thread(myThread);
        Thread t5 = new Thread(myThread);
        t1.start();     // 通知cpu此线程已经进入就绪状态，等待执行
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

}
