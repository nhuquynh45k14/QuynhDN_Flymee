package flymee.tasks;

import flymee.ui.HomePageUI;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class Search {
    public static Performable byKeyword(String keyword) {
        return Task.where("{0} searches product containing they word " + keyword,
                Enter.theValue(keyword).into(HomePageUI.TXT_SEARCH).thenHit(Keys.ENTER)
        );
    }
}
