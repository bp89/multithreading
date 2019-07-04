package com.cc.handlingExceptions.java_native;

import com.cc.handlingExceptions.util.ThreadTaskOneExceptionHandler;
import com.cc.handlingExceptions.util.ThreadTaskTwoExceptionHandler;

public class HandlingExceptionsThrownGloballyAndThreadLevelTogether {

  public static void main(String[] args) {
    Thread t1 = new Thread(() -> {
      throw new RuntimeException("Intentionally thrown RuntimeException");
    });

    Thread t2 = new Thread(() -> {
      throw new ArrayIndexOutOfBoundsException("Intentionally thrown ArrayIndexOutOfBoundsException");
    });

    Thread.setDefaultUncaughtExceptionHandler(new ThreadTaskOneExceptionHandler());
    t2.setDefaultUncaughtExceptionHandler(new ThreadTaskTwoExceptionHandler());

    t1.start();
    t2.start();
  }
}


