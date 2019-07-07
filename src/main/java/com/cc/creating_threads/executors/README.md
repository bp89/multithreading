The purpose of this section is to demonstrate that in large scale applications
we need to split thread creation and management from the actual business.
This job is easily done by `Executors`.

Executors class defines certain set of methods out of which some are used to create
three types of ExecutorService wrappers as below: 

1.Cached Thread pool - Not easily visible upper limit on thread pool. Max pool size is - 2147483647

2.Fixed size Thread pool - Only fixed number of threads to execute tasks

3.Single Thread executor - Only one thread is create and maintained throughout

Same has been demonstrated in this section.

Basically Executor library has following interfaces

**Executor**, a simple interface that supports launching new tasks.

**ExecutorService**, a subinterface of Executor, which adds features that help manage the lifecycle, both of the individual tasks and of the executor itself.

**ScheduledExecutorService**, a subinterface of ExecutorService, supports future and/or periodic execution of tasks.

We will only use ExecutorService for now & see how we can create instance of it in 3 different ways.
