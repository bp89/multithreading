package com.cc.creating_threads.java_native;

public class SecondWayOfCreatingThread {
    public static void main(String[] args) {
        new Thread(new SecondTask()).start();
    }
}

class SecondTask implements Runnable {

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Tick Tick" + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
