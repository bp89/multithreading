package com.cc.terminate_thread.executors.util;

import lombok.Data;

import java.util.concurrent.Callable;

@Data
public class TaskFactorialCalculator implements Callable {
  private int factNumber;
  static int count;

  public TaskFactorialCalculator(int factNumber) {
    this.factNumber = factNumber;
  }

  @Override
  public Integer call() {
    Thread.currentThread().setName("TaskLoopThroughExecutors " + ++count);
    int factNumber = this.factNumber;
    int factorial = 1;
    while (factNumber >= 1) {
      factorial *= factNumber--;

      try {
        System.out.println("Waiting for 500ms for thread " + Thread.currentThread().getName());
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    return factorial;
  }
}
