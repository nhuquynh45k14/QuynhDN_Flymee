package flymee.common;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class WaitABit implements Task {
    private final int second;

    public WaitABit(int second) {
        this.second = second;
    }

    public static WaitABit about(int second) {
        return Tasks.instrumented(WaitABit.class, second);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
