package com.cc;

public class FirstWayOfCreatingThread {


  public static void main(String[] args) {
    new FirstTask();
  }
}

class FirstTask extends Thread{

  @Override
  public void run() {
    for(int i=0;i<10;i++){
      System.out.println("Tick Tick" + i);

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public FirstTask(){
    this.start();
  }
}
