package demoqa.forms;

import demoqa.elements.ButtonElement;
import org.openqa.selenium.By;

import static demoqa.utils.ParameterizedXpathUtils.getXpathContainingText;

public class AccordionMenu extends BaseForm {
    private ButtonElement browserWindowsButton = new ButtonElement(getXpathContainingText("Browser"), "browserWindowsButtonInAccordion");
    private ButtonElement alertsButton = new ButtonElement(getXpathContainingText("Alerts"), "alertsButtonInAccordion");
    private ButtonElement framesButton = new ButtonElement(By.xpath("//li[@id='item-2']//span[contains(text(),'Frames')]"), "framesButtonInAccordion");
    private ButtonElement nestedFramesButton = new ButtonElement(getXpathContainingText("Nested"), "nestedFramesButtonInAccordion");
    private ButtonElement elementButton = new ButtonElement(By.xpath("//div[@class='element-group']//span[@class='pr-1']"), "elementButtonInAccordion");
    private ButtonElement webTablesButton = new ButtonElement(getXpathContainingText("Tables"), "webTablesButtonInAccordion");
    private ButtonElement linksButton = new ButtonElement(By.xpath("//div[contains(@class,'show')]//span[text()='Links']"), "linksButtonInAccordion");

    public AccordionMenu() {
        super(By.className("accordion"), "Form: accordionMenu");
    }

    public void clickOnBrowserWindowsButton() {
        browserWindowsButton.click();
    }

    public void clickOnAlertsButton() {
        alertsButton.click();
    }

    public void clickOnFramesButton() {
        framesButton.click();
    }

    public void clickOnNestedFramesButton() {
        nestedFramesButton.click();
    }

    public void clickOnElementsButton() {
        elementButton.click();
    }

    public void clickOnWebTables() {
        webTablesButton.click();
    }

    public void ClickOnLinksButton() {
        linksButton.click();
    }
}
