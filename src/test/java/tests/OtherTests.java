package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

@Tag("Regress")
public class OtherTests extends TestBase {

    @Test
    @DisplayName("тест 6")
    void test6() {
        MainPage mainPage = new MainPage();
        String title = mainPage.openPage()
                .getTitle();
        Assertions.assertEquals("Swag Labs", title);
    }

    @Test
    @DisplayName("тест 7")
    void test7() {
        MainPage mainPage = new MainPage();
        String title = mainPage.openPage()
                .getTitle();
        Assertions.assertEquals("Swag Labs", title);
    }

    @Test
    @DisplayName("тест 8")
    void test8() {
        MainPage mainPage = new MainPage();
        String title = mainPage.openPage()
                .getTitle();
        Assertions.assertEquals("Swag Labs", title);
    }

    @Test
    @DisplayName("тест 9")
    void test9() {
        MainPage mainPage = new MainPage();
        String title = mainPage.openPage()
                .getTitle();
        Assertions.assertEquals("h", title);
    }

    @Test
    @DisplayName("тест 10")
    void test10() {
        MainPage mainPage = new MainPage();
        String title = mainPage.openPage()
                .getTitle();
        Assertions.assertEquals("i", title);
    }
}
