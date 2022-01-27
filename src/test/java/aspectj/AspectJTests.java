package aspectj;

import aspectj.targets.Rabbit;
import org.junit.Test;

public class AspectJTests {
    @Test
    public void aspectjAnnotationBaseExample() {
        Rabbit rabbit = new Rabbit();

        rabbit.drink();
        System.out.println();
        rabbit.eat();
    }
}
