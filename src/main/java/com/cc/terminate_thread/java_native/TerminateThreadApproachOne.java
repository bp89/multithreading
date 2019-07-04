package com.cc.terminate_thread.java_native;

import lombok.Data;

public class TerminateThreadApproachOne {
  public static void main(String[] args) throws InterruptedException {

    TaskLoopThrough t1 = new TaskLoopThrough();
    TaskLoopThrough t2 = new TaskLoopThrough();

    t1.start();
    t2.start();

    Thread.sleep(2000);

    t1.cancelTask();

  }
}


@Data
class TaskLoopThrough extends Thread {
  private boolean terminate = false;
  static int count = 0;

  @Override
  public void run() {
    Thread.currentThread().setName("Task " + ++count);
    for (int i = 0; i <= 10; i++) {
      System.out.println(Thread.currentThread().getName() + " Tick Tick : " + i);

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (this) {
        if (terminate) {
          System.out.println("Terminating thread : " + Thread.currentThread().getName());
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
