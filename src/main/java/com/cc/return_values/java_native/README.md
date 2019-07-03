###Java's Native approach to create a Thread

There are basically 3 ways of creating threads in java. Ideally those are two but we say 3 because third approach is an inline approach which 
is very concise and usable when you want to declare and destroy thread on the go.

Following are the three approaches:

1. Using Thread class
2. Using Runnable Interface
3. Using anonymous inner class or Lambda Expression

1.**Using Thread class**

Basically  the Thread class itself implements the Runnable interface &  provides a lot of utility methods.

This is simple approach. Just extend the Thread class and override run method.

The disadvantage of this approach is that it don't allow inheritance further i.e. you can inherit any other class.

Below is an example for same:

```java

public class FirstWayOfCreatingThread {

    public static void main(String[] args) {
        new FirstTask();
    }
}

class FirstTask extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Tick Tick" + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public FirstTask() {
        this.start();
    }
}
``` 

2.**Using Runnable Interface:**

Simply create a class that implements Runnable interface and override the run method and we are done.

Example below:

```java
public class SecondWayOfCreatingThread {
    public static void main(String[] args) {
        new Thread(new SecondTask()).start();
    }
}

class SecondTask implements Runnable {

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Tick Tick" + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

Observe that we still need to create a Thread object and then call a Start method


3.**Using Lambda expression or inner class**

This approach is very simple and just the major difference is that you declare run method inline.

Below are both the appraoches:

i.Using lambda expression:

```java
public class ThirdWayOfCreatingThread {

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Tick Tick" + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
```

And below is example using Anonymous inner class:

```java
public class FourthWayOfCreatingThread {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Tick Tick" + i);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
``` 

Cheers!!!