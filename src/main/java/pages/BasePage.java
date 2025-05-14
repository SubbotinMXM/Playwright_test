//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.microsoft.playwright.options.WaitUntilState;
import config.ConfigurationManager;
import config.PlaywrightBase;
import utils.ReportingUtils;


public abstract class BasePage<T> {
    protected Page page = PlaywrightBase.getPage();

    protected BasePage() {
    }

    public abstract String getUrl();

    public String getTitle() {
        return this.page.title();
    }

    public T openPage() {
        Page.NavigateOptions navigateOptions = (new Page.NavigateOptions())
                .setTimeout((double) ConfigurationManager.config().timeout())
                .setWaitUntil(WaitUntilState.DOMCONTENTLOADED);
        this.page.navigate(this.getUrl(), navigateOptions);
        String var10000 = ConfigurationManager.config().baseUrl();
        ReportingUtils.addStep("Navigating to " + var10000 + this.getUrl());
        return (T)this;
    }

    public boolean isOpened() {
        String var10000 = ConfigurationManager.config().baseUrl();
        String currentPageUrl = var10000 + this.getUrl();
        return this.page.url().equals(currentPageUrl);
    }

    public void reloadPage() {
        this.page.reload();
    }

    public T clickOnText(String text) {
        this.page.click("text=" + text);
        return (T)this;
    }

    public T enableCheckboxByText(String text) {
        this.page.getByText(text).waitFor((new Locator.WaitForOptions())
                .setState(WaitForSelectorState.VISIBLE)
                .setTimeout((double)ConfigurationManager.config().timeout()));
        this.page.check("text=" + text);
        return (T)this;
    }

    public T pasteWithKeyword() {
        String osName = System.getProperty("os.name").toLowerCase();
        boolean isMac = osName.startsWith("mac");
        if (isMac) {
            this.page.keyboard().press("Meta+V");
        } else {
            this.page.keyboard().press("Control+V");
        }

        return (T)this;
    }

    public String getClipBoardText() {
        String clipboardText = this.page.evaluate("navigator.clipboard.readText()").toString();
        return clipboardText;
    }

    public void clickOnText(int index, String text) {
        this.page.getByText(text).nth(index).click();
    }
}
