package com.aston.service.impl;

import com.aston.service.LockScenarioStrategy;

public class DeadLockStrategy implements LockScenarioStrategy {

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    @Override
    public void run() {
        Thread firstThread = new Thread(() -> acquireLocks(lock1, lock2, "Thread-1"));
        Thread secondThread = new Thread(() -> acquireLocks(lock2, lock1, "Thread-2"));

        firstThread.start();
        secondThread.start();
    }

    private void acquireLocks(Object firstLock, Object secondLock, String threadName) {
        synchronized (firstLock) {
            System.out.println(threadName + " acquired first lock");
            sleep(100);
            synchronized (secondLock) {
                System.out.println(threadName + " acquired second lock");
            }
        }
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
