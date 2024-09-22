package demoqa.utils;

import org.openqa.selenium.Alert;

import static demoqa.utils.LoggerUtils.logMethod;

public class AlertsUtils {

    public static String getText() {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        logMethod(methodName);
        return ConditionalWaitUtils.waitForAlertIsPresent().getText();
    }

    public static void alertAccept() {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        logMethod(methodName);
        ConditionalWaitUtils.waitForAlertIsPresent().accept();
    }

    public static void sendRandomTextToAlert() {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        logMethod(methodName);
        Alert alert = ConditionalWaitUtils.waitForAlertIsPresent();
        String randomCharacters = RandomUtils.getRandString(5, "some", true);
        TestDataUtils.setRandomName(randomCharacters);
        alert.sendKeys(randomCharacters);
    }
}