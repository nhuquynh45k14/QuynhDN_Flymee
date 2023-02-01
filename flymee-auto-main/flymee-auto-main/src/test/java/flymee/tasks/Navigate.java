package flymee.tasks;

import flymee.ui.HomePageUI;
import flymee.ui.ProductPageUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class Navigate {
    public static Performable toTheHomePage() {
        return Task.where("{0} navigate to the home page",
                Open.browserOn(new HomePageUI())
        );
    }

    public static Performable toFavouritePage() {
        return Task.where("{0} navigate to the favourite page",
                Click.on(ProductPageUI.BTN_FAVOURITE)
        );
    }

    public static Performable byTableListNamed(String tabList, String option) {
        return Task.where("{0} navigate to the 'Category page' by option on tab list",
                MoveMouse.to(HomePageUI.TAB_LIST(tabList)),
                WaitUntil.the(HomePageUI.LBL_OPTION(option), isClickable()),
                Click.on(HomePageUI.LBL_OPTION(option))
        );
    }

    public static Performable toWarrantyBy(String name) {
        return Task.where("{0} navigate to the Warranty",
                Scroll.to(ProductPageUI.HYPER_LINK(name)),
                WaitUntil.the(ProductPageUI.HYPER_LINK(name), isClickable()),
                Click.on(ProductPageUI.HYPER_LINK(name))
        );
    }

}
