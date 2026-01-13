package com.taskreminder.task_reminder.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CoreJavaScheduler {

    private static final ScheduledExecutorService scheduler =
            Executors.newSingleThreadScheduledExecutor();

    public static void start() {
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Core Java Scheduler running (ScheduledExecutorService)");
        }, 0, 1, TimeUnit.MINUTES);
    }
}
