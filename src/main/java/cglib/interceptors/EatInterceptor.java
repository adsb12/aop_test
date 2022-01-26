package cglib.interceptors;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

// Rabbit 클래스 전용 인터셉터
public class EatInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = null;

        System.out.println("-- eat 메서드 호출 전 --");
        result = methodProxy.invokeSuper(o, objects);
        System.out.println("-- eat 메서드 호출 후 --");

        return result;
    }
}
