/**
 * We have got three examples here for following scenarios of exception handling for threads:
 * <p>
 * We need to declare our own custom uncaught exception handler class before to that. It should implement {@link java.lang.Thread.UncaughtExceptionHandler} interface & override
 * {@link java.lang.Thread.UncaughtExceptionHandler#uncaughtException(java.lang.Thread, java.lang.Throwable)} method.
 * <p>
 * Please take a look at {@link com.cc.handlingExceptions.java_native.DefaultExceptionHandler}
 *
 * <ol>
 * <li>Default Global exception handler for all threads. See class {@link com.cc.handlingExceptions.java_native.HandlingExceptionsThrownByThreadGlobally}</li>
 * <li>Thread wise local exception handler. See class {@link com.cc.handlingExceptions.java_native.HandlingExceptionsThrownGloballyAndThreadLevelTogether}</li>
 * <li>Default Global exception handler and local exception handler together for threads.
 * If specified local thread uncaught exception handler then global exception handler will be discarded.
 * See class {@link com.cc.handlingExceptions.java_native.HandlingExceptionsThrownGloballyAndThreadLevelTogether}</li>
 * </ol>
 */
package com.cc.handlingExceptions.java_native;