package tests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.MainPage;


import java.lang.reflect.Method;

import static config.PlaywrightBase.*;
import static utils.ReportingUtils.saveScreenshot;


public abstract class TestBase {

    @BeforeEach
    public void setUp() {
        createPlaywrightInstance();
        createBrowserInstance();
        createBrowserContextInstance();
        getBrowserContext();
        createPageInstance();
    }

    @AfterEach
    public void tearDown() {
        saveScreenshot();
        closeAll();
    }
}
