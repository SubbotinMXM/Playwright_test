package utils;

import com.microsoft.playwright.Page;
import config.PlaywrightBase;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class ReportingUtils {
    private ReportingUtils() {
    }

    @Attachment(
            value = "Screenshot {0}",
            type = "image/png"
    )
    public static byte[] saveScreenshot() {
        return PlaywrightBase.getPage().screenshot((new Page.ScreenshotOptions()).setFullPage(true));
    }

    @Step("{message}")
    public static void addStep(String message) {
        LogUtils.logAction(message);
    }

}
