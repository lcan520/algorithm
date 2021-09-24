package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  Java 堆内存溢出异常测试
 *  VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *  jmap -dump:format=b,file=test1 14709
 * </p>
 *
 * @author lcan520.cn
 * @date Created in 22:30 2021/9/2
 * @since 1.0.0
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
