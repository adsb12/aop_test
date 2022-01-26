package cglib.handlers;

import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

//CGLib 에서 Dynamic Proxy 에서 사용했던 핸들러 방식 사용하기
//java.lang.reflect.InvocationHandler; --> net.sf.cglib.proxy.InvocationHandler;만 바꿔주면 같은 코드 적용 가능
// 이는 자바 리플렉션을 사용한다.
public class AnimalProxyCGLibHandler implements InvocationHandler {

    Object target;

    public AnimalProxyCGLibHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("****before****");

        //메서드가 eat 이라면
        if(method.getName().equals("eat")) {
            System.out.println("----eat 메서드 호출 전----");

            result = method.invoke(target, args); // 메서드 호출 //자바의 리플렉션 사용

            System.out.println("----eat 메서드 호출 후----");
        } else if(method.getName().equals("drink")) { // 메서드가 drink 라면
            System.out.println("----drink 메서드 호출 전----");

            result = method.invoke(target, args); // 메서드 호출

            System.out.println("----drink 메서드 호출 후----");
        }

        System.out.println("****after****");
        return result; // 호출결과 반환
    }
}

