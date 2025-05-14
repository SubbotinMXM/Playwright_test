//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import java.util.ArrayList;
import java.util.List;

public enum BrowserFactory {
    CHROME {
        public Browser createInstance(Playwright playwright) {
            return playwright.chromium().launch(this.options().setChannel("chrome"));
        }
    },
    CHROMIUM {
        public Browser createInstance(Playwright playwright) {
            return playwright.chromium().launch(this.options("chromium"));
        }
    },
    FIREFOX {
        public Browser createInstance(Playwright playwright) {
            return playwright.firefox().launch(this.options("firefox"));
        }
    },
    WEBKIT {
        public Browser createInstance(Playwright playwright) {
            return playwright.webkit().launch(this.options("webkit"));
        }
    };

    private BrowserFactory() {
    }

    public BrowserType.LaunchOptions options() {
        return (new BrowserType.LaunchOptions())
                .setHeadless(ConfigurationManager.config().headless())
                .setTimeout((double)ConfigurationManager.config().timeout())
                .setSlowMo((double)ConfigurationManager.config().slowMo());
    }

    public BrowserType.LaunchOptions options(String actualBrowserName) {
        BrowserType.LaunchOptions launchOptions = (new BrowserType.LaunchOptions()).setHeadless(ConfigurationManager.config().headless());
        List<String> args = new ArrayList();
        if (!"chromium".equalsIgnoreCase(actualBrowserName) && !"chrome".equalsIgnoreCase(actualBrowserName)) {
            if ("webkit".equalsIgnoreCase(actualBrowserName)) {
                args.add("--no-startup-window");
            }
        } else {
            args.add("--no-default-browser-check");
            args.add("--start-maximized");
        }
        launchOptions.setArgs(args);
        launchOptions.setSlowMo((double)ConfigurationManager.config().slowMo());
        return launchOptions;
    }


    public abstract Browser createInstance(Playwright var1);
}
