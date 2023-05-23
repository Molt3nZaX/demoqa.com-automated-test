package demoqa.forms.pages;

import demoqa.elements.ButtonElement;
import demoqa.forms.BaseForm;

import static demoqa.utils.ParameterizedXpathUtils.getXpathButtonById;

public class BrowserWindowsPage extends BaseForm {
    private ButtonElement newTabButton = new ButtonElement(getXpathButtonById("tabButton"), "newTabButton");

    public BrowserWindowsPage() {
        super(getXpathButtonById("tabButton"), "browserWindowsPage");
    }

    public void clickNewTabButton() {
        newTabButton.click();
    }
}