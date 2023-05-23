package demoqa.browser;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static demoqa.utils.LoggerUtils.logMethod;

public class ActionsWithBrowser {
    private static final WebDriver webDriver = SingletonWebDriver.getWebDriver();

    public void switchToTab(int numberTab) {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        logMethod(methodName);
        List<String> browserTabs = new ArrayList<>(SingletonWebDriver.getWebDriver().getWindowHandles());
        webDriver.switchTo().window(browserTabs.get(numberTab));
    }

    public void closeCurrentTab() {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        logMethod(methodName);
        webDriver.close();
    }
}