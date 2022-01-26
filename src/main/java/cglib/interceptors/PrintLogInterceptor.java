package cglib.interceptors;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

// 앞 뒤로 로그 출력을 해주는 인터셉터
public class PrintLogInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        System.out.println("****before log****");
        result = methodProxy.invokeSuper(o, objects);
        System.out.println("****after log****");
        return result;
    }
}
