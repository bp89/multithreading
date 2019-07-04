package com.cc.terminate_thread.executors;

import com.cc.terminate_thread.executors.util.TaskLoopThroughExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TerminateThreadApproachOne {
  public static void main(String[] args) throws InterruptedException {
    TaskLoopThroughExecutors t1 = new TaskLoopThroughExecutors();
    TaskLoopThroughExecutors t2 = new TaskLoopThroughExecutors();

    ExecutorService executorService = Executors.newCachedThreadPool();
    executorService.submit(t1);
    executorService.submit(t2);

    Thread.sleep(2000);

    t1.cancelTask();

    executorService.shutdown();
  }
}


