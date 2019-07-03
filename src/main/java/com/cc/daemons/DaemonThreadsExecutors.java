package com.cc.daemons;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class DaemonThreadsExecutors {
  public static void main(String[] args) {

    Thread daemon1 = new Thread(() -> {
      System.out.println("Non Daemon thread:started");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Non Daemon thread:finished");
    });

    Thread daemon2 = new Thread(() -> {
      System.out.println("Daemon thread Started");

      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Daemon thread Finished");
    });

    ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFactory());
    executorService.submit(daemon1);
    executorService.submit(daemon2);
    try {
      Thread.sleep(1500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    executorService.shutdown();
  }

}

class DaemonThreadFactory implements ThreadFactory {

  @Override
  public Thread newThread(Runnable runnable) {
    Thread thread = new Thread(runnable);
    thread.setDaemon(true);
    return thread;
  }
}

