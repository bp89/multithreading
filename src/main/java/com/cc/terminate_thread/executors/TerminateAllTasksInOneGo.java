package com.cc.terminate_thread.executors;

import com.cc.terminate_thread.executors.util.TaskFactorialCalculator;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TerminateAllTasksInOneGo {
  public static void main(String[] args) throws InterruptedException, ExecutionException {


    TaskFactorialCalculator tf1 = new TaskFactorialCalculator(5);
    TaskFactorialCalculator tf2 = new TaskFactorialCalculator(10);
    ExecutorService executorService = Executors.newCachedThreadPool();

    Future<Integer> f1 = executorService.submit(tf1);
    Future<Integer> f2 = executorService.submit(tf2);

    Thread.sleep(1000);

    /**
     * Sends the interrupt signal to all the tasks / threads. This doesn't mean thread straightway terminates
     * FYI - Interrupt only interrupts blocked threads.
     *
     * Imp - You must have your own logic of termination in case of certain interruptions or expected behaviors
     */
    executorService.shutdownNow();

    executorService.awaitTermination(50, TimeUnit.MILLISECONDS);

    validateAndPrint(tf1, f1);
    validateAndPrint(tf2, f2);
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




