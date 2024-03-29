package com.cc.creating_threads.executors;

import com.cc.creating_threads.executors.util.Task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorServiceCachedThreadPool {

    public static void main(String[] args) {

        //as many threads are created and destroyed as required.
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Task());
        executorService.execute(new Task());
        executorService.execute(new Task());

        executorService.shutdown();
    }
}
