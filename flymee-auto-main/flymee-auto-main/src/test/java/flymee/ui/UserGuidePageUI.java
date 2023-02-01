package flymee.ui;

import net.serenitybdd.screenplay.targets.Target;

public class UserGuidePageUI {
    public static Target CONTENT(){
        return Target.the("Content")
                .locatedBy("//div[contains(@class,'textbox')]");
    }

    public static Target TITLE_RETURN(){
        return Target.the("Title return")
                .locatedBy("//*[@class='title']");
    }
}
