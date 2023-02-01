package flymee.ui;


import net.serenitybdd.screenplay.targets.Target;

public class FavouritesPageUI {
    public static Target PRODUCT_IN_FAVOURITE(String productName) {
        return Target.the("Product in favourite")
                .locatedBy("//*[@class='list_outer']//*[contains(text(),'" + productName + "')]");
    }

    public static Target BTN_DELETE_PRODUCT(String productName) {
        return Target.the("Button delete product")
                .locatedBy("//*[contains(text(),'" + productName + "')]//ancestor::*[@class='js-item']//div[contains(@class,'image_delete')]");
    }

    public static Target MSG_DELETE(String productName) {
        return Target.the("Message deleted")
                .locatedBy("//*[contains(text(),'" + productName + "')]//ancestor::*[@class='js-item']//div[contains(@class,'favorite_delete_cover')]");
    }
}
