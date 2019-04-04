package com.company.multi_thread.z;

class MyThread_1_1 extends Thread {



    public MyThread_1_1(int i) {
        Thread.currentThread().setName(i-1+"");
    }

    @Override
    public void run() {
        super.run();
        System.out.println(Thread.currentThread().getName());
    }
}

public class MyThread_1 {

    public static void main(String[] args) {
        MyThread_1_1 myThread11 = new MyThread_1_1(1);
        MyThread_1_1 myThread12 = new MyThread_1_1(1);
        MyThread_1_1 myThread13 = new MyThread_1_1(1);
        MyThread_1_1 myThread14 = new MyThread_1_1(1);
        MyThread_1_1 myThread15 = new MyThread_1_1(1);
        MyThread_1_1 myThread16 = new MyThread_1_1(1);
        MyThread_1_1 myThread17 = new MyThread_1_1(1);
        MyThread_1_1 myThread18 = new MyThread_1_1(1);
        myThread11.start();     // 通知cpu当前线程已就绪，cpu随机执行此线程
        myThread12.start();
        myThread13.start();
        myThread14.start();
        myThread15.start();
        myThread16.start();
        myThread17.start();
        myThread18.start();
    }

}
