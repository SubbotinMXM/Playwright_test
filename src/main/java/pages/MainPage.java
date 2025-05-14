package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;


public class MainPage extends BasePage<MainPage>{
    private final Locator pageTitle;
    private final Locator products;
    private final List<Integer> usedIndices = new ArrayList<>(); // Хранит индексы уже добавленных товаров

    public MainPage() {
        pageTitle = page.locator("//div[text()='Swag Labs']");
        products = page.locator("//div[@data-test='inventory-item-name']");
    }

    @Step("Проверка загрузки главной страницы")
    public MainPage checkPageLoaded(){
        PlaywrightAssertions.assertThat(pageTitle).isVisible();
        return this;
    }

    @Step("Добавление в корзину случайного товара")
    public String addRandomProductToCart(){
        int total = products.count();

        if (usedIndices.size() >= total) {
            throw new IllegalStateException("Все товары уже добавлены в корзину");
        }

        int randomIndex;
        do {
            randomIndex = (int) (Math.random() * total);
        } while (usedIndices.contains(randomIndex));

        usedIndices.add(randomIndex);

        Locator randomProduct = products.nth(randomIndex);
        String productName = randomProduct.textContent();

        randomProduct.locator("../../..//button[text()='Add to cart']").click();

        return productName;
    }

    @Override
    public String getUrl() {
        return "";
    }
}
