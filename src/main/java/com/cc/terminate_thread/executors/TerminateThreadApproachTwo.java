package com.cc.terminate_thread.executors;

import com.cc.terminate_thread.executors.util.TaskFactorialCalculator;
import com.cc.terminate_thread.executors.util.TaskLoopThroughExecutors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TerminateThreadApproachTwo {
  public static void main(String[] args) throws InterruptedException, ExecutionException {

    TaskFactorialCalculator tf1 = new TaskFactorialCalculator(5);
    TaskFactorialCalculator tf2 = new TaskFactorialCalculator(-1);
    ExecutorService executorService = Executors.newCachedThreadPool();

    Future<Integer> f1 = executorService.submit(tf1);
    Future<Integer> f2 = executorService.submit(tf2);

    Thread.sleep(1000);

    validateAndPrint(tf1, f1);
    validateAndPrint(tf2, f2);

    executorService.shutdown();
  }

  static void validateAndPrint(TaskFactorialCalculator taskFactorialCalculator, Future<Integer> integerFuture) throws ExecutionException, InterruptedException {
    while (true) {
      if (taskFactorialCalculator.getFactNumber() == -1) {
        System.out.println("Canceling the task as value less than 0 not acceptable");
        integerFuture.cancel(true);
        break;
      } else if (integerFuture.isDone()) {
        System.out.println("Factorial of " + taskFactorialCalculator.getFactNumber() + " is " + integerFuture.get());
        break;
      }
    }
  }
}




