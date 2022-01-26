package dynamicProxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class DynamicProxyTests {
    @Test
    public void dynamicProxyExample() {
        // Create the target instance
        Animal rabbitInstance = new Rabbit();
        Animal tigerInstance = new Tiger();

        // Create the proxy
        //동적으로 프록시 생성
        // rabbit
        Animal rabbit = (Animal) Proxy.newProxyInstance(Animal.class.getClassLoader(),
                rabbitInstance.getClass().getInterfaces(),
                new AnimalProxyHandler(rabbitInstance));
        // tiger
        Animal tiger = (Animal) Proxy.newProxyInstance(Animal.class.getClassLoader(),
                tigerInstance.getClass().getInterfaces(),
                new AnimalProxyHandler(tigerInstance));

        // Invoke the target instance method through the proxy
        rabbit.eat();
        System.out.println();
        rabbit.drink();
        System.out.println();

        tiger.eat();
        System.out.println();
        tiger.drink();
        System.out.println();
    }
    @Test
    public void dynamicProxyExampleInJava8Lambda() {
        //핸들러를 람다식으로 표현할 수 있다.

        // Create the target instance
        Animal rabbitInstance = new Rabbit();

        // Create the proxy
        //동적으로 프록시 생성하는데 핸들러를 람다로 구현
        Animal rabbit = (Animal) Proxy.newProxyInstance(Animal.class.getClassLoader(),
                rabbitInstance.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    Object result = null;
                    System.out.println("****before****");

                    //메서드가 eat 이라면
                    if(method.getName().equals("eat")) {
                        System.out.println("----eat 메서드 호출 전----");

                        result = method.invoke(rabbitInstance, args); // 메서드 호출

                        System.out.println("----eat 메서드 호출 후----");
                    } else if(method.getName().equals("drink")) { // 메서드가 drink 라면
                        System.out.println("----drink 메서드 호출 전----");

                        result = method.invoke(rabbitInstance, args); // 메서드 호출

                        System.out.println("----drink 메서드 호출 후----");
                    }

                    System.out.println("****after****");
                    return result; // 호출결과 반환
                });

        // Invoke the target instance method through the proxy
        rabbit.eat();
        System.out.println();
        rabbit.drink();
        System.out.println();
    }
}
