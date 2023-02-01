package flymee.tasks;

import flymee.ui.CartPageUI;
import flymee.ui.FavouritesPageUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Delete {
    public static Performable productInFavouriteBy(String productName) {
        return Task.where("{0} delete product in favourites by: " + productName,
                MoveMouse.to(FavouritesPageUI.PRODUCT_IN_FAVOURITE(productName)),
                Click.on(FavouritesPageUI.BTN_DELETE_PRODUCT(productName))
        );
    }
    public static Performable productInCartBy(String productName) {
        return Task.where("{0} delete product in cart by: " + productName,
                WaitUntil.the(CartPageUI.BTN_DELETE(productName), isVisible()),
                Click.on(CartPageUI.BTN_DELETE(productName))
        );
    }
}
