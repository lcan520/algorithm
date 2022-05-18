package demo;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * <p>
 *  工作窃取线程池使用测试
 * </p>
 *
 * @author lcan520.cn
 * @date Created in 14:39 2022/3/14
 * @since 1.0.0
 */
public class ForkJoinTestMain {
    public static void main(String[] args) {
        long[] numbers = new long[10000];
        for (int i = 0; i < 10000; i++) {
            numbers[i] = i;
        }
        ForkJoinTest forkJoinTest = new ForkJoinTest();
        forkJoinTest.sumUp(numbers);
    }
}

class ForkJoinTest {
    private ForkJoinPool pool;

    private static class SumTask extends RecursiveTask<Long> {
        private long[] numbers;
        private int from;
        private int to;

        public SumTask(long[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            // 当需要计算的数字小于6时，直接计算结果
            if (to - from < 6) {
                long total = 0;
                for (int i = from; i <= to; i++) {
                    total += numbers[i];
                }
                return total;
                // 否则，把任务一分为二，递归计算
            } else {
                int middle = (from + to) / 2;
                SumTask taskLeft = new SumTask(numbers, from, middle);
                SumTask taskRight = new SumTask(numbers, middle+1, to);
                taskLeft.fork();
                taskRight.fork();
                long l = taskLeft.join() + taskRight.join();
                System.out.println(l);
                return l;
            }
        }
    }

    public ForkJoinTest() {
        // 也可以使用公用的 ForkJoinPool：
        // pool = ForkJoinPool.commonPool()
        pool = new ForkJoinPool();
    }

    public long sumUp(long[] numbers) {
        return pool.invoke(new SumTask(numbers, 0, numbers.length-1));
    }
}
