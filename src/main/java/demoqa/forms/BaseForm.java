package demoqa.forms;

import demoqa.utils.ConditionalWaitUtils;
import demoqa.utils.LoggerUtils;
import org.openqa.selenium.By;

public abstract class BaseForm extends LoggerUtils {
    private final By uniqueLocator;
    private final String pageName;

    public BaseForm(By locator, String name) {
        this.uniqueLocator = locator;
        this.pageName = name;
    }

    public String getPageName() {
        return pageName;
    }

    public boolean isPageOpened() {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        logInfo("Page: " + getPageName() + " - ", methodName);
        return ConditionalWaitUtils.waitToBeClickable(uniqueLocator).isDisplayed();
    }
}