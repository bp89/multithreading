package com.cc.handlingExceptions.java_native;

public class DefaultExceptionHandler implements Thread.UncaughtExceptionHandler {

  @Override
  public void uncaughtException(Thread thread, Throwable throwable) {
    System.out.println("Thread named " + thread.getName() + " has thrown exception " + throwable.getMessage());

  }
}
