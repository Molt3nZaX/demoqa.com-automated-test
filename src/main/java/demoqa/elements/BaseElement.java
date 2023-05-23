package demoqa.elements;

import demoqa.utils.ConditionalWaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static demoqa.utils.LoggerUtils.logInfo;

abstract class BaseElement {
    private final By uniqueLocator;
    private final String uniqueElementName;

    public BaseElement(By locator, String elementName) {
        this.uniqueLocator = locator;
        this.uniqueElementName = elementName;
    }

    public String getName() {
        return uniqueElementName;
    }

    public void click() {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        logInfo(getName() + " - ", methodName);
        ConditionalWaitUtils.waitForPresenceOfElementLocated(uniqueLocator).click();
    }

    public boolean isDisplayed() {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        logInfo(getName() + " - ", methodName);
        return ConditionalWaitUtils.waitForPresenceOfElementLocated(uniqueLocator).isDisplayed();
    }

    public String getText() {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        logInfo(getName() + " - ", methodName);
        return ConditionalWaitUtils.waitForPresenceOfElementLocated(uniqueLocator).getText();
    }

    public WebElement findElement() {
        return ConditionalWaitUtils.waitForPresenceOfElementLocated(uniqueLocator);
    }

    public List<WebElement> findElements() {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        logInfo(getName() + " - ", methodName);
        return ConditionalWaitUtils.waitForPresenceOfAllElementsLocatedBy(uniqueLocator);
    }
}