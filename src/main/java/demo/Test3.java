package demo;

/**
 * <p>
 *
 * </p>
 *
 * @author lcan520.cn
 * @date Created in 19:55 2021/12/6
 * @since 1.0.0
 */
public class Test3 {


    public static void main(String[] args) throws InterruptedException {

        // 1. 打印线程运行类

        Thread printer1 = new Thread(new Printer(0),"Printer1");

        Thread printer2 = new Thread(new Printer(1),"Printer2");

        Thread printer3 = new Thread(new Printer(2),"Printer3");

        // 开始线程
        printer1.start();
        printer2.start();
        printer3.start();

    }
}

class Printer implements Runnable {

    private static Object lock = new Object();

    private static int i;

    int no;

    public Printer(int no){
        this.no = no;
    }

    @Override
    public void run() {
        // 所有唤醒线程
        for(;;) {
            synchronized (lock) {
                if (i > 100) {
                    break;
                }
                if (i % 3 == this.no) {
                    i++;
                    System.out.println(Thread.currentThread().getName() + "-" + i);
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notifyAll();
            }
        }


    }
}
