package demoqa.elements;

import org.openqa.selenium.By;

public class LabelElement extends BaseElement {
    public LabelElement(By locatorToElement, String elementName) {
        super(locatorToElement, "Label: " + elementName);
    }
}