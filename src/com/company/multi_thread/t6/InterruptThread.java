package com.company.multi_thread.t6;

class Test extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 50000; i++) {
            System.out.println("i=" + (i+1));
        }
    }
}

public class InterruptThread {

    public static void main(String[] args) {
        try {
            Test t = new Test();
            t.start();
            Thread.sleep(2000);
//            t.interrupt();          // 没有停止线程
            Thread.currentThread().interrupt();
            System.out.println("是否停止1:"+ t.interrupted());
            System.out.println("是否停止2:"+ t.interrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }

}
