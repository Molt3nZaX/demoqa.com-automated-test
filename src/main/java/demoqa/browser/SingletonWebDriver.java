package demoqa.browser;

import demoqa.utils.ActionsUtils;
import demoqa.utils.ConditionalWaitUtils;
import demoqa.utils.ConfigDataUtils;
import demoqa.utils.JsExecutor;
import org.openqa.selenium.WebDriver;

public class SingletonWebDriver {
    private static WebDriver webDriver;
    private static final String browser = ConfigDataUtils.getBrowserConfig().getBrowser();

    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = BrowserFactory.getBrowser(browser);
        }
        return webDriver;
    }

    public static void teardown() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
            ActionsUtils.killActionsUtils();
            BrowserFactory.killDriver();
            ConditionalWaitUtils.killWebDriverWait();
            JsExecutor.killJsExecutor();
        }
    }
}