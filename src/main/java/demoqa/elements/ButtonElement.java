package demoqa.elements;

import org.openqa.selenium.By;

public class ButtonElement extends BaseElement {
    public ButtonElement(By locatorToElement, String elementName) {
        super(locatorToElement, "Button: " + elementName);
    }
}