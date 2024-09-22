package demoqa.utils;

import org.openqa.selenium.By;

public class ParameterizedXpathUtils {
    public static By getXpathContainingText(String text) {
        return By.xpath("//span[contains(text(),'" + text + "')]");
    }

    public static By getXpathButtonById(String text) {
        return By.xpath("//button[@id='" + text + "']");
    }

    public static By getXpathInputById(String text) {
        return By.xpath("//input[@id='" + text + "']");
    }
}