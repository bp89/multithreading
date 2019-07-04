package com.cc.handlingExceptions.java_native;

public class HandlingExceptionsThrownByThreadGlobally {

  public static void main(String[] args) {
    Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler());

    new Thread(() -> {
      throw new RuntimeException("Intentional exception");
    }).start();
  }
}
