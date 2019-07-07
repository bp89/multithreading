package com.cc.creating_threads.executors;

import com.cc.creating_threads.executors.util.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class UsingThreadPoolExecutor {

    public static void main(String[] args) throws InterruptedException {

        //as many threads are created and destroyed as required.
        ExecutorService executorService = Executors.newCachedThreadPool();

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
        threadPoolExecutor.setCorePoolSize(2);
        System.out.println(threadPoolExecutor.getCorePoolSize());
        System.out.println(threadPoolExecutor.getMaximumPoolSize());

        executorService.execute(new Task());
        executorService.execute(new Task());
        executorService.execute(new Task());

        executorService.shutdown();
        Thread.sleep(10000);
    }
}
