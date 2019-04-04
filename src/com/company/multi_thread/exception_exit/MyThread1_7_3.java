package com.company.multi_thread.exception_exit;

public class MyThread1_7_3 extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 50000; i++) {
            if (this.isInterrupted()) {
                System.out.println("已经是停止状态，推出");
                break;
            }
            System.out.println("i = " + (i+1));
        }
    }

    public static void main(String[] args) {
        try {
            MyThread1_7_3 myThread1_7_3 = new MyThread1_7_3();
            myThread1_7_3.start();
            Thread.sleep(2000);
            myThread1_7_3.interrupt();
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }

}
