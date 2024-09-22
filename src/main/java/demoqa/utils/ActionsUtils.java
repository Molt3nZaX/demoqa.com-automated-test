package demoqa.utils;

import demoqa.browser.SingletonWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static demoqa.utils.LoggerUtils.logMethod;

public class ActionsUtils {
    private static Actions actions;

    public static Actions getActions() {
        if (actions == null) {
            actions = new Actions(SingletonWebDriver.getWebDriver());
        }
        return actions;
    }

    public static void killActionsUtils() {
        actions = null;
    }

    public static void clickOnButton(WebElement button) {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        logMethod(methodName + " \"" + button.getText() + "\"");
        getActions().moveToElement(button).click().perform();
    }
}