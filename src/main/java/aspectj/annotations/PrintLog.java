package aspectj.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//어느레벨까지 유지되는지를 결정
@Target(ElementType.METHOD) //선언한 어노테이션이 적용될 수 있는 위치
public @interface PrintLog {
    public boolean printAround() default true;
    public boolean printBefore() default true;
    public boolean printAfter() default true;
}
