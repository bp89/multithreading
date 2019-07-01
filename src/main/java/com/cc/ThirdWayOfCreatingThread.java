package com.cc;

public class ThirdWayOfCreatingThread {

  public static void main(String[] args) {
    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        System.out.println("Tick Tick" + i);

        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();
  }
}


