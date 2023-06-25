package lesson20230623;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

// Пример рекурсивного многопоточного вычисления суммы числовой последовательности c ForkJoinPool
public class ForkJoinPoolCalculator extends RecursiveTask<Long> {

    public static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();
    // Порог разбиения последовательности
    public static final long THRESHOLD = 10_000;

    private final long[] numbers;
    private final int start;
    private final int end;

    public ForkJoinPoolCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinPoolCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        ForkJoinPoolCalculator leftTask = new ForkJoinPoolCalculator(numbers, start, start + length/2);
        leftTask.fork();
        ForkJoinPoolCalculator rightTask = new ForkJoinPoolCalculator(numbers, start + length/2, end);
        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();
        return leftResult + rightResult;
    }

    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinPoolCalculator(numbers);
        return FORK_JOIN_POOL.invoke(task);
    }

    public static void main(String[] args) {
        long sum = forkJoinSum(100_000_000);
        System.out.println(sum);
    }
}
