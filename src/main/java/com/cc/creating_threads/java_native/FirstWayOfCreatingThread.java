package com.cc.creating_threads.java_native;

public class FirstWayOfCreatingThread {

    public static void main(String[] args) {
        Thread t1 = new FirstTask();
        t1.start();
        Thread t2 = new FirstTask();
        t2.start();

    }
}

class FirstTask extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print(Thread.currentThread().getName());
            System.out.println(" Tick Tick" + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
