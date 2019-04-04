package com.company.multi_thread.t6;


class MythreadIsAlive extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("Thread is alive :" + Thread.currentThread().isAlive());
    }
}

public class IsAlive {

    public static void main(String[] args) throws Exception {
//        MythreadIsAlive m = new MythreadIsAlive();
//        Thread t = new Thread(m);
//        System.out.println("Thread is alive : " + t.isAlive());
//        t.start();
//        Thread.sleep(1);    // 在1毫秒之内，子线程会关闭
//        System.out.println("Thread is alive : " + t.isAlive());
        System.out.println(Thread.currentThread().getId());
    }

}
