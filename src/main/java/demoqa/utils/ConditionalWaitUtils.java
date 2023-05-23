package demoqa.utils;

import demoqa.browser.SingletonWebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ConditionalWaitUtils {
    private static WebDriverWait webDriverWait;
    private static final int EXPLICITLY_WAIT = ConfigDataUtils.getBrowserConfig().getExplicitlyWait();

    public static WebDriverWait getWebDriverWait() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(SingletonWebDriver.getWebDriver(), Duration.ofSeconds(EXPLICITLY_WAIT));
        }
        return webDriverWait;
    }

    public static void killWebDriverWait() {
        webDriverWait = null;
    }

    public static WebElement waitForPresenceOfElementLocated(By uniqueLocator) {
        return getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(uniqueLocator));
    }

    public static WebElement waitToBeClickable(By uniqueLocator) {
        return getWebDriverWait().until(ExpectedConditions.elementToBeClickable(uniqueLocator));
    }

    public static List<WebElement> waitForPresenceOfAllElementsLocatedBy(By uniqueLocator) {
        return getWebDriverWait().until(ExpectedConditions.presenceOfAllElementsLocatedBy(uniqueLocator));
    }

    public static Alert waitForAlertIsPresent() {
        return getWebDriverWait().until(ExpectedConditions.alertIsPresent());
    }
}