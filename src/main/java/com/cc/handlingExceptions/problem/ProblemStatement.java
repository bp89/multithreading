package com.cc.handlingExceptions.problem;

public class ProblemStatement {

  public static void main(String[] args) {
    try {
      new Thread(() -> {
        throw new RuntimeException();
      }).start();
    } catch (RuntimeException ie) {
      System.out.println("Exception inside thread::"); //not printed
      ie.printStackTrace();
    }
  }
}
