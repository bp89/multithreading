package com.cc.return_values.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorAppraochOne {
  public static void main(String[] args) {

    ExecutorService executorService = Executors.newCachedThreadPool();

    Future<Integer> sum1 = executorService.submit(new SumTask(2, 3));
    Future<Integer> sum2 = executorService.submit(new SumTask(5, 7));

    executorService.shutdown();

    try {
      System.out.println("Result-1 = " + sum1.get());
      System.out.println("Result-2 = " + sum2.get());
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
  }
}

class SumTask implements Callable<Integer> {
  private int a;
  private int b;
  private static int count = 0;

  SumTask(int a, int b) {
    this.a = a;
    this.b = b;
  }

  @Override
  public Integer call() throws Exception {
    System.out.println("Thread #" + Thread.currentThread().getName() + ++count);
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return a + b;
  }
}
