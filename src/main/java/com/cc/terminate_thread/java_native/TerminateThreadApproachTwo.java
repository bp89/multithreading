package com.cc.terminate_thread.java_native;

import lombok.Data;

/**
 * Uses interrupted method
 *
 * Note:- Same applies to terminating a blocked thread as thread is blocked when  it's waiting infinitely
 */
public class TerminateThreadApproachTwo {
  public static void main(String[] args) throws InterruptedException {

    TaskLoopThroughTwo t1 = new TaskLoopThroughTwo();
    TaskLoopThroughTwo t2 = new TaskLoopThroughTwo();

    t1.start();
    t2.start();


    Thread.sleep(2000);

    t1.interrupt(); // it just interrupts on blocks e.g. wait, sleep. Actual termination of thread is controlled by thread itself.
  }
}


@Data
class TaskLoopThroughTwo extends Thread {
  static int count = 0;

  @Override
  public void run() {
    Thread.currentThread().setName("Task " + ++count);
    for (int i = 0; i <= 10; i++) {
      System.out.println(Thread.currentThread().getName() + " Tick Tick : " + i);

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
        interrupt();
      }

      //Do some more work if required

      if (Thread.interrupted()) {
        System.out.println("Value of interrupted " + Thread.interrupted()); //return false as called second time
        System.out.println("Terminating the thread " + Thread.currentThread().getName());
        break;
      }
    }
  }

}
