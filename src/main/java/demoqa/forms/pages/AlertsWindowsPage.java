package demoqa.forms.pages;

import demoqa.elements.ButtonElement;
import demoqa.elements.LabelElement;
import demoqa.forms.BaseForm;
import org.openqa.selenium.By;

import static demoqa.utils.ParameterizedXpathUtils.getXpathButtonById;

public class AlertsWindowsPage extends BaseForm {
    private ButtonElement toSeeAlertButton = new ButtonElement(getXpathButtonById("alertButton"), "toSeeAlertButton");
    private ButtonElement confirmBoxButton = new ButtonElement(getXpathButtonById("confirmButton"), "confirmBoxButton");
    private ButtonElement promptBoxButton = new ButtonElement(getXpathButtonById("promtButton"), "promptBoxButton");
    private LabelElement confirmResultText = new LabelElement(By.xpath("//span[@id='confirmResult']"), "confirmResultText");
    private LabelElement promptResultText = new LabelElement(By.xpath("//span[@id='promptResult']"), "promptResultText");

    public AlertsWindowsPage() {
        super(getXpathButtonById("alertButton"), "alertsWindowsPage");
    }

    public boolean buttonToSeeAlertIsDisplayed() {
        return toSeeAlertButton.isDisplayed();
    }

    public void clickButtonToSeeAlert() {
        toSeeAlertButton.click();
    }

    public void clickButtonConfirmBox() {
        confirmBoxButton.click();
    }

    public void clickButtonPromptBox() {
        promptBoxButton.click();
    }

    public String getConfirmResultText() {
        return confirmResultText.getText();
    }

    public String getPromptResultText() {
        return promptResultText.getText();
    }
}