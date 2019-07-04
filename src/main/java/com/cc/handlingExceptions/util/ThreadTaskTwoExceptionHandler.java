package com.cc.handlingExceptions.util;

public class ThreadTaskTwoExceptionHandler implements Thread.UncaughtExceptionHandler {

  @Override
  public void uncaughtException(Thread thread, Throwable throwable) {
    System.out.println("Thread named " + thread.getName() + " has " + throwable.getMessage());

  }
}
