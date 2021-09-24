package jvm;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *
 * </p>
 *
 * @author lcan520.cn
 * @date Created in 11:41 2021/9/3
 * @since 1.0.0
 */
public class ThreadTest {
    static volatile int count = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            System.out.println("11:" + count);
            executorService.submit(new Runnable() {
                @Override
                public void run() {

                    System.out.println(count());
                }
            });
        }
        executorService.shutdownNow();

    }

    private static int count() {
        return count++;
    }
    class IntegerCount{
        int count = 0;
        int repeat = 0;
    }

}
