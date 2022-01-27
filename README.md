# java-aop
`JDK Dynamic Proxy`, `CGLIB`, `AspectJ` 실습 예제 코드입니다.


```
.
├── README.md
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   ├── aspectj
    │   │   │   ├── annotations
    │   │   │   │   └── PrintLog.java
    │   │   │   ├── aspect
    │   │   │   │   └── LogAspect.java
    │   │   │   └── targets
    │   │   │       └── Rabbit.java
    │   │   ├── cglib
    │   │   │   ├── Rabbit.java
    │   │   │   ├── Tiger.java
    │   │   │   ├── callbackFilters
    │   │   │   │   └── AnimalMethodCallbackFilter.java
    │   │   │   ├── handlers
    │   │   │   │   └── AnimalProxyCGLibHandler.java
    │   │   │   └── interceptors
    │   │   │       ├── DrinkInterceptor.java
    │   │   │       ├── EatInterceptor.java
    │   │   │       └── PrintLogInterceptor.java
    │   │   └── dynamicProxy
    │   │       ├── Animal.java
    │   │       ├── AnimalProxyHandler.java
    │   │       ├── Rabbit.java
    │   │       └── Tiger.java
    │   └── resources
    │       └── META-INF
    │           └── aop.xml
    └── test
        └── java
            ├── aspectj
            │   └── AspectJTests.java
            ├── cglib
            │   └── CGLibTests.java
            └── dynamicProxy
                └── DynamicProxyTests.java
```