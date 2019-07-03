package com.cc.daemons;

public class DaemonThreadNative {
  public static void main(String[] args) {

    new Thread(() -> {
      System.out.println("Non Daemon thread:started");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Non Daemon thread:finished");
    }).start();

    Thread daemon = new Thread(() -> {
      System.out.println("Daemon thread Started");

      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Daemon thread Finished");
    });

    daemon.setDaemon(true);
    daemon.start();

  }

}

