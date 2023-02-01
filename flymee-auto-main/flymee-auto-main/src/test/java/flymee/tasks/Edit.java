package flymee.tasks;

import flymee.common.WaitABit;
import flymee.ui.ProductPageUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class Edit {
    public static Performable quantityBy(int quantity) {
        return Task.where("{0} add to Cart by ",
                actor -> {
                    for (int i = 0; i < quantity; i++) {
                        actor.attemptsTo(
                                Click.on(ProductPageUI.ICON_PLUS)
                        );
                    }
                    actor.attemptsTo(
                            Click.on(ProductPageUI.BTN_ADD_TO_CART)
                    );
                }
        );
    }
}
