package com.cc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class NamingExecutorServiceThreads {

  public static void main(String[] args) {

    ExecutorService executorService = Executors.newFixedThreadPool(2, new CustomThreadFactory());

    executorService.execute(new TaskN());
    executorService.execute(new TaskN());
    executorService.execute(new TaskN());

    executorService.shutdown();
  }

}

class TaskN implements Runnable {
  @Override
  public void run() {
    for (int i = 1; i <= 10; i++) {
      System.out.println("[" + Thread.currentThread().getName() + "]Tick Tock : " + i);

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class CustomThreadFactory implements ThreadFactory {

  static int thread = 0;

  @Override
  public Thread newThread(Runnable runnable) {


    return new Thread(runnable, "My Thread - " + ++thread);
  }
}