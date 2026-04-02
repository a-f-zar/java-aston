package com.aston.service.impl;

import com.aston.service.LockScenarioStrategy;

public class AlternatingPrintStrategy implements LockScenarioStrategy {

    private final Object monitor = new Object();
    private boolean printOne = true;

    @Override
    public void run() {
        Thread firstThread = new Thread(() -> print("1", true));
        Thread secondThread = new Thread(() -> print("2", false));

        firstThread.start();
        secondThread.start();
    }

    private void print(String value, boolean isFirstThread) {
        while (true) {
            synchronized (monitor) {
                while (printOne != isFirstThread) {
                    waitForTurn();
                }
                System.out.println(value);
                printOne = !printOne;
                monitor.notifyAll();
            }
        }
    }

    private void waitForTurn() {
        try {
            monitor.wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
