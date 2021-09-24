package jvm;

/**
 * <p>
 *  VM Args: -Xss128k
 * </p>
 *
 * @author lcan520.cn
 * @date Created in 23:24 2021/9/2
 * @since 1.0.0
 */
public class JavaVMStatckSOF {

    private int stackLength = 1;

    private void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStatckSOF oom = new JavaVMStatckSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("栈深度：" + oom.stackLength);
            throw e;
        }
    }
}
