package com.cc.return_values;

import lombok.Builder;
import lombok.Data;

public class ThreadsApproachTwo {

  public static void main(String[] args) {

    ValueReturnTask2 task1 = ValueReturnTask2.builder()
      .a(3)
      .b(4)
      .build();
    Thread t1 = new Thread(task1, "ValueReturnTask2");

    ValueReturnTask2 task2 = ValueReturnTask2.builder()
      .a(1)
      .b(8)
      .build();
    Thread t2 = new Thread(task2, "ValueReturnTask2");

    ValueReturnTask2 task3 = ValueReturnTask2.builder()
      .a(2)
      .b(9)
      .build();
    Thread t3 = new Thread(task3, "ValueReturnTask2");

    t1.start();
    t2.start();
    t3.start();


    System.out.println("Result-1 = " + task1.getSum());
    System.out.println("Result-2 = " + task2.getSum());
    System.out.println("Result-3 = " + task3.getSum());

  }
}


@Data
@Builder
class ValueReturnTask2 implements Runnable {
  private int a;
  private int b;
  private int sum;

  private boolean done = false;
  private static int count = 0;

  @Override
  public void run() {

    System.out.println("Thread #" + Thread.currentThread().getName() + ++count);

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    sum = a + b;

    done = true;

    synchronized (this) {
      this.notifyAll();
    }
  }

  public int getSum() {

    if (!done) {
      try {
        System.out.println("Waiting to be notified by thread" );
        synchronized (this) {
          this.wait();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    return sum;
  }
}
