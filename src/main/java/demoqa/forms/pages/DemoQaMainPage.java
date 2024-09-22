package demoqa.forms.pages;

import demoqa.elements.ButtonElement;
import demoqa.forms.BaseForm;
import demoqa.utils.ActionsUtils;
import demoqa.utils.DataConstantsUtils;
import demoqa.utils.JsExecutor;
import org.openqa.selenium.By;

public class DemoQaMainPage extends BaseForm implements DataConstantsUtils {
    private ButtonElement alertFrameWindowsButton = new ButtonElement(By.xpath("//h5[contains(text(),'Alerts')]"), "alertFrameWindowsButton");
    private ButtonElement elementsButton = new ButtonElement( By.xpath("//h5[contains(text(),'Elements')]"), "elementsButton");

    public DemoQaMainPage() {
        super(By.xpath("//div[contains(@class,'banner')]"), "mainPage");
    }

    public void moveToAlertsFrameWindowsButtonAndClick() {
        JsExecutor.scrollDown(MAX_SCROLL);
        ActionsUtils.clickOnButton(alertFrameWindowsButton.findElement());
    }

    public void moveToElementsButtonAndClick() {
        JsExecutor.scrollDown(MAX_SCROLL);
        ActionsUtils.clickOnButton(elementsButton.findElement());
    }
}