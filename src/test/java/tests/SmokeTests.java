package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;

@Tag("Regress")
@Tag("Smoke")
public class SmokeTests extends TestBase {

    @Test
    @DisplayName("тест 1")
    void test1() {
        MainPage mainPage = new MainPage();
        String title = mainPage.openPage()
                .getTitle();
        Assertions.assertEquals("Swag Labs", title);
    }

    @Test
    @DisplayName("тест 2")
    void test2() {
        MainPage mainPage = new MainPage();
        String title = mainPage.openPage()
                .getTitle();
        Assertions.assertEquals("Swag Labs", title);
    }

    @Test
    @DisplayName("тест 3")
    void test3() {
        MainPage mainPage = new MainPage();
        String title = mainPage.openPage()
                .getTitle();
        Assertions.assertEquals("Swag Labs", title);
    }

    @Test
    @DisplayName("тест 4")
    void test4() {
        MainPage mainPage = new MainPage();
        String title = mainPage.openPage()
                .getTitle();
        Assertions.assertEquals("ф", title);
    }

    @Test
    @DisplayName("тест 5")
    void test5() {
        MainPage mainPage = new MainPage();
        String title = mainPage.openPage()
                .getTitle();
        Assertions.assertEquals("й", title);
    }
}
