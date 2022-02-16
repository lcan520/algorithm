package demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *
 * </p>
 *
 * @author lcan520.cn
 * @date Created in 19:55 2021/12/6
 * @since 1.0.0
 */
public class Test2 {


    public static void main(String[] args) {

        //ZeroEvenOdd evenOdd = new Test2().new ZeroEvenOdd(Integer.parseInt(args[0]));
        ZeroEvenOdd evenOdd = new Test2().new ZeroEvenOdd(2);

        Thread zero = new Thread(evenOdd::zero);

        Thread even = new Thread(evenOdd::even);

        Thread odd = new Thread(evenOdd::odd);

        // 开始线程
        zero.start();
        even.start();
        odd.start();

    }

    class ZeroEvenOdd {

        public volatile int n = 0;

        public volatile AtomicInteger count = new AtomicInteger();

        // 构造函数
        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // 仅打印出 0
        public void zero() {

            while (count.get() < 2 * n) {
                synchronized (this){
                    System.out.print(0);
                    count.incrementAndGet();
                }

            }
        }

        // 仅打印出 偶数
        public void even() {
            synchronized (this) {
                while (count.get() < 2 * n) {
                    System.out.print(2 * count.get());
                    count.incrementAndGet();
                }
            }
        }

        // 仅打印出 奇数
        public void odd() {
            synchronized (this) {
                while (count.get() < 2 * n) {
                    System.out.print(2 * count.get() + 1);
                    count.incrementAndGet();
                }
            }

        }

    }
}
