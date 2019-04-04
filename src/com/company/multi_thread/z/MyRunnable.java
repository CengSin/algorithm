package com.company.multi_thread.z;

class t3 implements Runnable {

    private int count = 5;

    public t3(String name) {
        Thread.currentThread().setName(name);
    }

    @Override
    public void run() {
        while(count-- != 0) {
            System.out.println("线程：" + Thread.currentThread().getName() + ", count=" + this.count);
        }
    }
}

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "运行中");
    }

    public static void main(String[] args) {
//        MyRunnable myRunnable = new MyRunnable();
//        Thread thread = new Thread(myRunnable);
//        thread.start();
//        System.out.println(Thread.currentThread().getName() + "运行结束");
        for (int i =1; i <= 5; i++) {
            t3 t = new t3(i+"");
            Thread thread = new Thread(t);
            thread.start();
        }
    }
}
