package com.qburry.concurrent;

import static com.qburry.concurrent.utils.Utils.printThread;
import static com.qburry.concurrent.utils.Utils.sleep;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Sample {

    public int compute(final int x) {
        printThread("Computing " + x + "...");
        sleep(2, SECONDS);
        printThread("Computed " + x + ".");
        return x;
    }

    public int add(final int x, final int y) {
        printThread("Adding " + x + " and " + y + "...");
        sleep(2, SECONDS);
        final int r = x + y;
        printThread("Added " + x + " and " + y + ".");
        return r;
    }

    public int subtract(final int x, final int y) {
        printThread("Subtracting " + x + " and " + y + "...");
        sleep(2, SECONDS);
        final int r = x + y;
        printThread("Subtracted " + x + " and " + y + ".");
        return r;
    }

    public int multiply(final int x, final int y) {
        printThread("Multiplying " + x + " and " + y + "...");
        sleep(2, SECONDS);
        final int r = x + y;
        printThread("Multiplied " + x + " and " + y + ".");
        return r;
    }

}
