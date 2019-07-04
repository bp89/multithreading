package com.cc.creating_threads.executors;

public class Task implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("[" + Thread.currentThread().getName() + "]ABRACADABARA : " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
