package com.qburry.concurrent;

import com.qburry.concurrent.utils.Utils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

import static com.qburry.concurrent.utils.Utils.stopwatch;
import static java.util.concurrent.CompletableFuture.completedFuture;
import static java.util.concurrent.CompletableFuture.supplyAsync;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SampleTest {

    private Sample sample = new Sample();

    @BeforeAll
    void setUp() {
        sample = new Sample();
    }

    @Nested
    class SimpleTask {

        @Test
        void testSynchronous() {
            stopwatch(() -> {
                int x1 = sample.compute(1);
                int x2 = sample.add(x1, 1);
                int y = sample.compute(2);
                int z = sample.add(x2, y);
                Utils.printThread("Result: " + z);
            });
        }

        @Test
        void testAsynchronous() {
            stopwatch(() -> {
                CompletableFuture<Integer> x1 = supplyAsync(() -> sample.compute(1));
                CompletableFuture<Integer> x2 = x1.thenApply(i -> sample.add(i, 1));
                CompletableFuture<Integer> y = supplyAsync(() -> sample.compute(2));

                try {
                    x2.thenCombine(y, (i, j) -> sample.add(i, j))
                            .thenAccept(i -> Utils.printThread("Result: " + i))
                            .get();
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    @Nested
    class SumAndMax {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> multiplier = Stream.of(1, 2, 3);

        @Test
        void testSynchronous() {
            stopwatch(() -> {
                Stream<Integer> computedIntegerStream = integerStream.map(i -> sample.compute(i));
                Integer sum = computedIntegerStream.reduce(0, (a, b) -> sample.add(a, b));
                Integer[] arr = multiplier.map(i -> sample.multiply(sum, i)).toArray(Integer[]::new);
                Integer max = Arrays.stream(arr)
                        .max(Comparator.naturalOrder())
                        .orElse(null);
                System.out.println("Result: " + max);
            });
        }

        @Test
        void testAsynchronous() {
            stopwatch(() -> {
                Stream<CompletableFuture<Integer>> cis = integerStream.map(x -> supplyAsync(() -> sample.compute(x)));
                CompletableFuture<Integer> sum = cis.reduce(completedFuture(0), (a, b) -> a.thenCombine(b, (i, j) -> sample.add(i, j)));
                CompletableFuture<Integer>[] array = multiplier.
                        map(x -> sum.thenApplyAsync(s -> sample.multiply(s, x)))
                        .toArray(CompletableFuture[]::new);

                CompletableFuture<Integer> max = CompletableFuture.allOf(array).thenApply(
                        (Void) -> Arrays.stream(array)
                                .map(y -> y.getNow(Integer.MAX_VALUE))
                                .max(Comparator.naturalOrder())
                                .orElse(0)
                );

                try {
                    System.out.println("Result: " + max.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

}