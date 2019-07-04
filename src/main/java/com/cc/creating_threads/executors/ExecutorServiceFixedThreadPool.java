package com.cc.creating_threads.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceFixedThreadPool {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(new Task());
        executorService.execute(new Task());
        executorService.execute(new Task());

        executorService.shutdown();
    }
}

