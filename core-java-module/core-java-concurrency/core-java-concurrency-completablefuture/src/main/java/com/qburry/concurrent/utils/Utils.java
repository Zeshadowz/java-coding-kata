package com.qburry.concurrent.utils;

import java.util.concurrent.TimeUnit;

public class Utils {

    public static void stopwatch(final Runnable consumer) {
        final long start = System.nanoTime();
        consumer.run();
        System.out.println("Elapsed time: " + (System.nanoTime() - start) / 1_000_000);
    }

    public static void sleep(final int duration, final TimeUnit unit) {
        try {
            unit.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printThread(final String message) {
        System.out.println("[" + Thread.currentThread().getName() + "]: " + message);
    }
}
