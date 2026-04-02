package com.aston.service.impl;

import com.aston.service.LockScenarioStrategy;

public class LiveLockStrategy implements LockScenarioStrategy {

    private final SharedResource resource = new SharedResource("Thread-1");

    @Override
    public void run() {
        Worker firstWorker = new Worker("Thread-1", true);
        Worker secondWorker = new Worker("Thread-2", true);

        Thread firstThread = new Thread(() -> firstWorker.work(resource, secondWorker));
        Thread secondThread = new Thread(() -> secondWorker.work(resource, firstWorker));

        firstThread.start();
        secondThread.start();
    }

    private static class SharedResource {
        private volatile String ownerName;

        private SharedResource(String ownerName) {
            this.ownerName = ownerName;
        }
    }

    private static class Worker {
        private final String name;
        private final boolean polite;

        private Worker(String name, boolean polite) {
            this.name = name;
            this.polite = polite;
        }

        private void work(SharedResource resource, Worker otherWorker) {
            while (true) {
                if (!resource.ownerName.equals(name)) {
                    sleep(50);
                    continue;
                }

                if (polite && otherWorker.isActive()) {
                    System.out.println(name + " transfers resource to " + otherWorker.name);
                    resource.ownerName = otherWorker.name;
                    sleep(50);
                    continue;
                }

                System.out.println(name + " completed work");
                resource.ownerName = otherWorker.name;
            }
        }

        private boolean isActive() {
            return true;
        }

        private void sleep(long millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
