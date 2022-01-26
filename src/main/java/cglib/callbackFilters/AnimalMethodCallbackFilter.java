package cglib.callbackFilters;

import cglib.Rabbit;
import cglib.Tiger;
import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

// 메서드가 eat 이냐 drink 냐에 따라 해당하는 인덱스 반환해주는 필터
public class AnimalMethodCallbackFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if(method.getName().equals("eat")) return 0;
        if(method.getName().equals("drink")) return 1;
        return 0; // 해당하지 않으면 그냥 0반환
    }
}
