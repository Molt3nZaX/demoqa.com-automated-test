package demoqa.elements;

import org.openqa.selenium.By;

import static demoqa.utils.LoggerUtils.logInfo;

public class TextBoxElement extends BaseElement {
    public TextBoxElement(By locatorToElement, String elementName) {
        super(locatorToElement, "Text box: " + elementName);
    }

    public void findElementAndSendKeys(String text) {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        logInfo(getName() + " - ", methodName);
        findElement().sendKeys(text);
    }
}