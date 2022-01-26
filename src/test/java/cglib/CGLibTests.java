package cglib;

import cglib.callbackFilters.AnimalMethodCallbackFilter;
import cglib.handlers.AnimalProxyCGLibHandler;
import cglib.interceptors.DrinkInterceptor;
import cglib.interceptors.EatInterceptor;
import cglib.interceptors.PrintLogInterceptor;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

public class CGLibTests {

    @Test
    public void byInterceptorExample() {
        //Enhancer 객체를 생성
        Enhancer rabbitEnhancer = new Enhancer();
        // setSuperclass() 메소드에 프록시할 클래스 지정
        rabbitEnhancer.setSuperclass(Rabbit.class);
        // 로그 출력해주는 인터셉터 지정
        rabbitEnhancer.setCallback(new PrintLogInterceptor());
        Rabbit rabbit = (Rabbit) rabbitEnhancer.create(); // 프록시 생성

        rabbit.eat();
        System.out.println();
        rabbit.drink();
    }
    @Test
    public void byInterceptorExample2() {
        Rabbit rabbit = (Rabbit) Enhancer.create(Rabbit.class, new PrintLogInterceptor());

        rabbit.eat();
        System.out.println();
        rabbit.drink();
    }

    @Test
    public void callbackFilterExample() {
        //콜백 필터를 이용해 필터 조건에 따라 다른 인터셉터 적용하기 예제
        //메서드가 무엇이냐에 따라 해당 인터셉터를 적용한다.
        //Enhancer 객체를 생성
        Enhancer rabbitEnhancer = new Enhancer();
        // setSuperclass() 메소드에 프록시할 클래스 지정
        rabbitEnhancer.setSuperclass(Rabbit.class);
        //메서드 이름에 따라 인덱스 반환해주는 콜백 필터 지정, 0 반환 시 EatInterceptor, 1 반환 시 DrinkInterceptor
        rabbitEnhancer.setCallbackFilter(new AnimalMethodCallbackFilter());
        // 콜백 배열 지정
        rabbitEnhancer.setCallbacks(new Callback[]{
                new EatInterceptor(), // 0
                new DrinkInterceptor() // 1
        });
        Rabbit rabbit = (Rabbit) rabbitEnhancer.create(); // 프록시 생성

        rabbit.eat();
        System.out.println();
        rabbit.drink();
    }

    //CGLib 에서 Dynamic Proxy 에서 사용했던 핸들러 방식 사용하기
    // 이는 자바 리플렉션을 사용한다.
    @Test
    public void byHandlerExample() {
        //Enhancer 객체를 생성
        Enhancer rabbitEnhancer = new Enhancer();
        // setSuperclass() 메소드에 프록시할 클래스 지정
        rabbitEnhancer.setSuperclass(Rabbit.class);
        rabbitEnhancer.setCallback(new AnimalProxyCGLibHandler(new Rabbit())); // 핸들러 지정
        Rabbit rabbit = (Rabbit) rabbitEnhancer.create(); // 프록시 생성

        rabbit.eat();
        System.out.println();
        rabbit.drink();
    }

    //CGLib 에서 Dynamic Proxy 에서 사용했던 핸들러 방식 사용하기
    // 이는 자바 리플렉션을 사용한다.
    @Test
    public void byHandlerExample2() {
        Rabbit rabbit = (Rabbit) Enhancer.create(Rabbit.class, new AnimalProxyCGLibHandler(new Rabbit())); // 프록시 생성

        rabbit.eat();
        System.out.println();
        rabbit.drink();
    }
}
