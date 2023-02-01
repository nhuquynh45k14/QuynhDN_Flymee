package flymee.tests;

import flymee.tasks.*;
import flymee.ui.*;
import flymee.common.WaitABit;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.*;
import flymee.tasks.Navigate;
import flymee.tasks.Search;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Title;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.containsString;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

@ExtendWith(SerenityJUnit5Extension.class)
@Tag("UI")
public class UITests {
    @CastMember(name = "Tester")
    Actor tester;

    @Test
    @Title("Add to favourite item")
    void test_add_to_favourite() {
        givenThat(tester).wasAbleTo(
                Navigate.toTheHomePage()
        );
        when(tester).attemptsTo(
                Search.byKeyword("ユーティリティ ソファ ツーサイド L"),
                Add.productToFavouriteByName("ユーティリティ ソファ ツーサイド L")
        );
        then(tester).attemptsTo(
                Ensure.that(ProductPageUI.ICON_FAVOURITE_ACTIVE).isDisplayed()
        );
    }

    @Test
    @Title("Add and Remove Favourite")
    void test_case_02() {
        givenThat(tester).attemptsTo(
                Navigate.toTheHomePage()
        );
        when(tester).attemptsTo(
                Search.byKeyword("ユーティリティ ソファ ツーサイド L"),
                Add.productToFavouriteByName("ユーティリティ ソファ ツーサイド L"),
                Navigate.toFavouritePage()
        );
        then(tester).attemptsTo(
                Ensure.that(FavouritesPageUI.PRODUCT_IN_FAVOURITE("ユーティリティ ソファ ツーサイド L")).isDisplayed()
        );
        when(tester).attemptsTo(
                Delete.productInFavouriteBy("ユーティリティ ソファ ツーサイド L")
        );
        then(tester).attemptsTo(
                Ensure.that(FavouritesPageUI.MSG_DELETE("ユーティリティ ソファ ツーサイド L")).hasText("削除しました")
        );
        when(tester).attemptsTo(
                Browser.refreshPage()
        );
        then(tester).attemptsTo(
                Ensure.that(FavouritesPageUI.PRODUCT_IN_FAVOURITE("ユーティリティ ソファ ツーサイド L")).isNotDisplayed()
        );
    }

    @Test
    @Title("Verify that 'user' can Add/Remove 'Case09' to/from Cart")
    void testcase_4() {
        givenThat(tester).wasAbleTo(
                Navigate.toTheHomePage()
        );
        when(tester).attemptsTo(
                Search.byKeyword("バット アウトドアチェア（ニューベージュ）"),
                Add.productToCartByName("バット アウトドアチェア（ニューベージュ）"),
                Delete.productInCartBy("バット アウトドアチェア（ニューベージュ）")
        );
        then(tester).attemptsTo(
                WaitABit.about(3),
                Check.whether(Visibility.of(CartPageUI.LBL_PRODUCT_LIST))
                        .andIfSo(
                                Ensure.that(CartPageUI.PRODUCT_NAME("バット アウトドアチェア（ニューベージュ）")).isNotDisplayed()
                        )
                        .otherwise(
                                Ensure.that(CartPageUI.LBL_MESSAGE).isDisplayed(),
                                Ensure.that(Text.of(CartPageUI.LBL_MESSAGE)).isEqualTo("カートに商品はありません")
                        )
        );
    }

    @Test
    @Title("TC3")
    void test_03() {
        givenThat(tester).wasAbleTo(Navigate.toTheHomePage());
        when(tester).attemptsTo(
                Search.byKeyword("バット アウトドアチェア（ニューベージュ）"),
                Click.on(CollectionPageUI.PRODUCT("バット アウトドアチェア（ニューベージュ）"))
        );
        and(tester).attemptsTo(
                Click.on(ProductPageUI.BTN_ADD_TO_CART),
                WaitUntil.the(CartPageUI.PRODUCT_NAME("バット アウトドアチェア（ニューベージュ）"), isVisible())
        );
        then(tester).attemptsTo(
                Ensure.that(Text.of(CartPageUI.LBL_PRICE("バット アウトドアチェア（ニューベージュ）"))).isEqualTo("¥64,240"),
                Ensure.that(Text.of(CartPageUI.LBL_QUANTITY("バット アウトドアチェア（ニューベージュ）"))).isEqualTo("1")
        );
    }

    @Test
    @Title("Navigate to Category page by 'type' of product")
    void test_10() {
        givenThat(tester).wasAbleTo(
                Navigate.toTheHomePage()
        );
        when(tester).attemptsTo(
                Navigate.byTableListNamed("カテゴリー", "食器・テーブルウェア")
        );
        then(tester).should(
                seeThat(Text.of(CategoryPageUI.LBL_TITLE), containsString("食器・テーブルウェア")),
                seeThat(the(CategoryPageUI.LBL_REFINE_GROUP("食器・テーブルウェア")), isVisible())
        );
    }

    @Test
    @Title("Navigate to Shop by color page by 'color' of product")
    void test_11() {
        givenThat(tester).wasAbleTo(
                Navigate.toTheHomePage()
        );
        when(tester).attemptsTo(
                Navigate.byTableListNamed("カラー", "イエロー")
        );
        then(tester).should(
                seeThat(Text.of(ShopByColorPageUI.LBL_TITLE), containsString("イエロー")),
                seeThat(the(ShopByColorPageUI.LBL_REFINE_GROUP("イエロー")), isVisible())
        );
    }

    @Test
    @Title("")
    void test_07() {
        givenThat(tester).attemptsTo(
                Navigate.toTheHomePage()
        );
        when(tester).attemptsTo(
                Search.byKeyword("バット アウトドアチェア（ニューベージュ）"),
                Click.on(CollectionPageUI.PRODUCT("バット アウトドアチェア（ニューベージュ）")),
                Navigate.toWarrantyBy("保証について")
        );
        then(tester).should(
                seeThat(the(UserGuidePageUI.CONTENT()), containsText("FLYMEeではお買い上げいただいた家具・照明に関しまして、一部商品を除き、安心保証をお付けしています。保証対象商品には商品詳細ページに上記の「保証付」アイコンがございますのでそちらをご確認ください。" + "\n" +
                        "保証期間満了後や保証対象外の有償修理などにつきましては、内容により適宜対応させて頂きますので、どうぞお気軽にご相談ください。"))

        );
    }

    @Test
    @Title("")
    void test_08() {
        givenThat(tester).attemptsTo(
                Navigate.toTheHomePage()
        );
        when(tester).attemptsTo(
                Search.byKeyword("バット アウトドアチェア（ニューベージュ）"),
                Add.productToCartByName("バット アウトドアチェア（ニューベージュ）")
        );
        and(tester).attemptsTo(
                Click.on(CartPageUI.RETURN("返品・交換・キャンセルについて")),
                Switch.toNewWindow()
        );
        then(tester).attemptsTo(
                Ensure.that(UserGuidePageUI.TITLE_RETURN()).hasText("返品・交換・キャンセルについて")
        );
        then(tester).should(
                seeThat(the(UserGuidePageUI.CONTENT()), containsText("ご納期確定後（ご納期確定メール配信後）のキャンセル・内容変更（追加・変更）は承ることが出来ません。")));
    }

    @Test
    @Title("TC9")
    void test_09() {
        givenThat(tester).wasAbleTo(Navigate.toTheHomePage());
        when(tester).attemptsTo(
                Search.byKeyword("バット アウトドアチェア（ニューベージュ）"),
                Click.on(CollectionPageUI.PRODUCT("バット アウトドアチェア（ニューベージュ）"))
        );
        and(tester).attemptsTo(
                Click.on(ProductPageUI.BTN_ADD_TO_CART),
                WaitUntil.the(CartPageUI.PRODUCT_NAME("バット アウトドアチェア（ニューベージュ）"), isVisible()));
        and(tester).attemptsTo(
                Click.on(CartPageUI.IMAGE_PRODUCT("バット アウトドアチェア（ニューベージュ）")),
                WaitUntil.the(ProductPageUI.TXT_QUANTITY, isVisible()),
                Edit.quantityBy(3)
        );
        then(tester).attemptsTo(
                WaitUntil.the(CartPageUI.LBL_QUANTITY("バット アウトドアチェア（ニューベージュ）"), isVisible()),
                Ensure.that(Text.of(CartPageUI.LBL_QUANTITY("バット アウトドアチェア（ニューベージュ）"))).isEqualTo("5"),
                Ensure.that(Text.of(CartPageUI.LBL_AMOUNT)).isEqualTo("¥321,200")
        );
    }

    @Test
    @Title("Verify url")
    void test_05() {
        givenThat(tester).wasAbleTo(
                Navigate.toTheHomePage()
        );
        when(tester).attemptsTo(
                Click.on(HomePageUI.LINK_TEXT("会員登録"))
        );
        then(tester).attemptsTo(
                Ensure.thatTheCurrentPage().currentUrl().endsWith("/member/register/")
        );
    }

    @Test
    @Title("Verify url")
    void test_06() {
        givenThat(tester).wasAbleTo(
                Navigate.toTheHomePage()
        );
        when(tester).attemptsTo(
                Search.byKeyword("バット アウトドアチェア（ニューベージュ）"),
                Add.productToCartByName("バット アウトドアチェア（ニューベージュ）"),
                Click.on(HomePageUI.LINK_TEXT("新規会員登録はこちら"))
        );
        then(tester).attemptsTo(
                Ensure.thatTheCurrentPage().currentUrl().endsWith("/member/register/")
        );
    }
}
