package flymee.tasks;

import flymee.ui.CollectionPageUI;
import flymee.ui.ProductPageUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class Add {
    public static Performable productToCartByName(String productName) {
        return Task.where("{0} add to Cart by " + productName,
                actor -> {
                    actor.attemptsTo(
                            Click.on(CollectionPageUI.PRODUCT(productName)),
                            WaitUntil.the(ProductPageUI.BTN_ADD_TO_CART, isClickable()),
                            Click.on(ProductPageUI.BTN_ADD_TO_CART)
                    );
                }
        );
    }

    public static Performable productToFavouriteByName(String productName) {
        return Task.where("{0} add to favourite by " + productName,
                actor -> {
                    actor.attemptsTo(
                            Click.on(CollectionPageUI.PRODUCT(productName)),
                            WaitUntil.the(ProductPageUI.ICON_FAVOURITE, isClickable()),
                            Click.on(ProductPageUI.ICON_FAVOURITE)
                    );
                }
        );
    }
}
