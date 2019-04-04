package com.company.multi_thread.t6;

public class Run1 implements Runnable {

    public Run1() {
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Run1 r1 = new Run1();
        Thread thread = new Thread(r1);
        //thread.start();     // 通知cpu线程就绪，cpu分配时间片给线程，线程执行代码
        thread.run();       // main线程继续获得cpu的执行权，此时的线程还是main
    }

}
