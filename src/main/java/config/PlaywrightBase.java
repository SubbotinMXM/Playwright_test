//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.ViewportSize;

import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class PlaywrightBase {
    private static final ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal();
    private static final ThreadLocal<Browser> browserThreadLocal = new ThreadLocal();
    private static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal();
    private static final ThreadLocal<BrowserContext> browserContextThreadLocal = new ThreadLocal();

    private PlaywrightBase() {
    }

    public static void createPlaywrightInstance() {
        playwrightThreadLocal.set(Playwright.create());
    }

    public static void createBrowserInstance() {
        Playwright playwright = getPlaywright();
        if (playwright == null) {
            throw new PlaywrightException("Playwright object instance is required to create a Browser instance");
        } else {
            String browserName = ConfigurationManager.config().browser();
            Browser browser = BrowserFactory.valueOf(browserName.toUpperCase()).createInstance(getPlaywright());
            browserThreadLocal.set(browser);
        }
    }

    public static void changeUser(String token) {
        BrowserContext browserContext = getBrowserContext();
        browserContext.setExtraHTTPHeaders(Map.of("X-Token", token));
        browserContextThreadLocal.set(browserContext);
    }

    public static void createBrowserContextInstance() {
        Browser browser = getBrowser();
        if (browser == null) {
            throw new PlaywrightException("Browser instance is required to create a Browser Context instance");
        }
        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions()
                .setViewportSize(new ViewportSize(1700, 1080))
                .setBaseURL(ConfigurationManager.config().baseUrl());
        BrowserContext browserContext = browser.newContext(contextOptions);
        browserContext.setDefaultTimeout((double) ConfigurationManager.config().timeout());
        browserContextThreadLocal.set(browserContext);

    }

    public static void createPageInstance() {
        BrowserContext browserContext = getBrowserContext();
        if (browserContext == null) {
            throw new PlaywrightException("Browser context is required to create a Page instance");
        } else {
            pageThreadLocal.set(browserContext.newPage());
        }
    }

    public static Playwright getPlaywright() {
        return (Playwright) playwrightThreadLocal.get();
    }

    public static Browser getBrowser() {
        return (Browser) browserThreadLocal.get();
    }

    public static Page getPage() {
        return (Page) pageThreadLocal.get();
    }

    public static BrowserContext getBrowserContext() {
        return (BrowserContext) browserContextThreadLocal.get();
    }

    public static void closeAll() {

        if (pageThreadLocal.get() != null) {
            pageThreadLocal.remove();
        }

        if (browserContextThreadLocal.get() != null) {
            ((BrowserContext) browserContextThreadLocal.get()).close();
            browserContextThreadLocal.remove();
        }

        if (browserThreadLocal.get() != null) {
            ((Browser) browserThreadLocal.get()).close();
            browserThreadLocal.remove();
        }

        if (playwrightThreadLocal.get() != null) {
            ((Playwright) playwrightThreadLocal.get()).close();
            playwrightThreadLocal.remove();
        }

    }
}
