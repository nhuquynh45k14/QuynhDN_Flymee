package flymee.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("page:base.url")
public class HomePageUI extends PageObject {
    public static Target LINK_AREA(String title) {
        return Target.the("Link area: " + title)
                .locatedBy("//*[@class='top_contents']//*[text()='" + title + "']");
    }

    public static Target LBL_CATEGORY(String type) {
        return Target.the("Category of  " + type)
                .locatedBy("//*[@class='title']/..//*[text()='" + type + "']");
    }

    public static Target TAB_LIST(String type) {
        return Target.the("Tab list of  " + type)
                .locatedBy("//*[@class='header_nav']//*[text()='" + type + "']");
    }

    public static Target LBL_OPTION(String type) {
        return Target.the("Category of  " + type)
                .locatedBy("//*[@class='header_nav']//*[text()='" + type + "']");
    }

    public static Target TXT_SEARCH = Target.the("text search")
            .locatedBy("//input[@id='js-searchKeywords']");

    public static Target LINK_TEXT(String name) {
        return Target.the("Button on header")
                .located(By.linkText(name));
    }
}
