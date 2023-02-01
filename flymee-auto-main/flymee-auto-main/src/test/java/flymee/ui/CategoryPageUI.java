package flymee.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CategoryPageUI {
    public static Target LBL_REFINE_GROUP(String filter) {
        return Target.the("Refine list has filter: " + filter)
                .locatedBy("//*[@id='search-option-chips']//span[contains(.,'" + filter + "')]");
    }

    public static Target LBL_TITLE = Target.the("Page title")
            .locatedBy("//*[@id='search-header']//*[@class='title']");
}
