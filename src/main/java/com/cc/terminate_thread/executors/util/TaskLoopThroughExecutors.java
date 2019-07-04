package com.cc.terminate_thread.executors.util;

import lombok.Data;

@Data
public class TaskLoopThroughExecutors extends Thread {
  private boolean terminate = false;
  static int count = 0;

  @Override
  public void run() {
    Thread.currentThread().setName("TaskLoopThroughExecutors " + ++count);
    for (int i = 0; i < 10; i++) {
      System.out.println(Thread.currentThread().getName() + " Tick Tick : " + i);

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (this) {
        if (terminate) {
          System.out.println("Terminating TaskLoopThroughExecutors : " + Thread.currentThread().getName());
          break;
        }
      }
    }
  }

  public void cancelTask() {
    synchronized (this) {
      terminate = true;
    }
  }
}
