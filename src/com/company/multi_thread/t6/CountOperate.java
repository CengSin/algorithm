package com.company.multi_thread.t6;

public class CountOperate extends Thread{
    public CountOperate() {
        System.out.println("Constructor --begin");
        func();
        System.out.println("Constructor --end");
    }

    private void func() {
        System.out.println("Thread reference objet name: " + this.getName());
        System.out.println("Thread Name: " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run --begin");
        func();
        System.out.println("run --end");
    }

    public static void main(String[] args) {
        CountOperate c = new CountOperate();
        Thread thread = new Thread(c);
        thread.setName("A");
        thread.start();
    }

}
