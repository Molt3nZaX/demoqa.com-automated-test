package demoqa.utils;

import demoqa.browser.SingletonWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static demoqa.utils.LoggerUtils.logMethod;

public class FramesUtils {
    private static final WebDriver webDriver = SingletonWebDriver.getWebDriver();

    public static void switchToFrame(String locator) {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        logMethod(methodName);
        WebElement frame = ConditionalWaitUtils.waitForPresenceOfElementLocated(By.id(locator));
        webDriver.switchTo().frame(frame);
    }

    public static void switchToChild() {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        logMethod(methodName);
        webDriver.switchTo().frame(0);
    }

    public static void defaultContent() {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        logMethod(methodName);
        webDriver.switchTo().defaultContent();
    }
}