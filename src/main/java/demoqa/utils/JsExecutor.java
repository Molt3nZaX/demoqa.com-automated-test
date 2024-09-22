package demoqa.utils;

import demoqa.browser.SingletonWebDriver;
import org.openqa.selenium.JavascriptExecutor;

import static demoqa.utils.LoggerUtils.logMethod;

public class JsExecutor {
    private static JavascriptExecutor javascriptExecutor;

    public static JavascriptExecutor getJavascriptExecutor() {
        if (javascriptExecutor == null) {
            javascriptExecutor = (JavascriptExecutor) SingletonWebDriver.getWebDriver();
        }
        return javascriptExecutor;
    }

    public static void killJsExecutor() {
        javascriptExecutor = null;
    }

    public static void scrollDown(int pixels) {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        logMethod(methodName);
        getJavascriptExecutor().executeScript("window.scrollBy(0, " + pixels + ")");
    }
}