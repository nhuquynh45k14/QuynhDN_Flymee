package flymee.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPageUI {

    public static Target BTN_DELETE(String productName) {
        return Target.the("button remove 'Case09' from Cart")
                .locatedBy("//p[contains(.,'" + productName + "')]/..//*[contains(@class,'delete_button_text')]");
    }

    public static Target PRODUCT_NAME(String productName) {
        return Target.the("'product' Cart")
                .locatedBy("//*[@class='js-cart']//p[contains(.,'" + productName + "')]");
    }

    public static Target LBL_PRICE(String productName) {
        return Target.the("price")
                .locatedBy("//p[contains(.,'" + productName + "')]/../..//*[@class='list_price']");
    }

    public static Target LBL_QUANTITY(String productName) {
        return Target.the("quantity")
                .locatedBy("//p[contains(.,'" + productName + "')]/../..//*[@class='list_quantity']//*[@class='sum']");
    }

    public static Target RETURN(String name) {
        return Target.the("Return")
                .located(By.linkText(name));
    }
    public static Target IMAGE_PRODUCT(String productName){
            return Target.the("product image")
                    .locatedBy("//p[contains(.,'" + productName + "')]/../..//*[@class='list_image']");
        }
    public static Target LBL_PRODUCT_LIST = Target.the("List product in Cart")
            .locatedBy("//*[@class='product_list']");

    public static Target LBL_MESSAGE = Target.the("Message")
            .locatedBy("//*[@class='js-cart']//p");

    public static Target LBL_AMOUNT = Target.the("amount")
            .locatedBy("//*[@class='sub_total']//*[@class='amount']");

}
