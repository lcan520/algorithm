package jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p>
 *  Java 7 以前存在老年代逻辑分区
 *  Vm Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *  Java 8 使用元空间代替
 *  Vm Args: -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 * </p>
 *
 * @author lcan520.cn
 * @date Created in 23:48 2021/9/2
 * @since 1.0.0
 */
public class JavaMethodAreaOOM {

    public static void main(final String[] args) {
        while (true) {
            final Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject {
    }

}
