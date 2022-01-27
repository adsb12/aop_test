package aspectj.targets;

import aspectj.annotations.PrintLog;

public class Rabbit {
    @PrintLog
    public void eat() {
        // around, before, after 로그 출력
        System.out.println("토끼가 음식을 먹습니다.");
    }

    @PrintLog(printAround = false)
    public void drink() {
        // before, after 로그 출력
        System.out.println("토끼가 물을 마십니다.");
    }
}
