package com.cc.return_values.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorAppraochTwo {
  public static void main(String[] args) {

    ExecutorService executorService = Executors.newCachedThreadPool();
    CompletionService<Integer> tasks = new ExecutorCompletionService<>(executorService);
    tasks.submit(new SumTask1(2, 3));
    tasks.submit(new SumTask1(5, 7));

    executorService.shutdown();

    Future<Integer> sum;
    while ((sum = tasks.poll()) != null) {
      try {
        System.out.println("Result = " + sum.get()); //To return identity of thread you could return  a bean with sum
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }
  }
}

class SumTask1 implements Callable<Integer> {
  private int a;
  private int b;
  private static int count = 0;

  SumTask1(int a, int b) {
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
