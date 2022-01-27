package aspectj.aspect;

import aspectj.annotations.PrintLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect //aspect 임을 알림
public class LogAspect {
    @Pointcut("@annotation(printLog)")
    public void callAt(PrintLog printLog) {

    }
    @Around("callAt(printLog)")
    public Object aroundLog(ProceedingJoinPoint pjp, PrintLog printLog) throws Throwable {
        if(!printLog.printAround()) return pjp.proceed();

        String name = pjp.getSignature().toShortString();
        System.out.println("** " + name + " around log 실행**");
        Object result = pjp.proceed();
        System.out.println("** " + name + " around log 끝**");
        return result;
    }

    @Before("callAt(printLog)")
    public void beforeLog(PrintLog printLog) {
        if(printLog.printBefore()) {
            System.out.println("-- before log --");
        }
    }

    @After("callAt(printLog)")
    public void afterLog(PrintLog printLog) {
        if(printLog.printAfter()) {
            System.out.println("-- after log --");
        }
    }
}
