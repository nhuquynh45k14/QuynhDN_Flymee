package flymee.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CollectionPageUI {
    public static Target PRODUCT(String name) {
        return Target.the("Product: " + name)
                .locatedBy("//*[contains(@class,'search_result')]//*[contains(text(),'" + name + "')]");
    }
}
