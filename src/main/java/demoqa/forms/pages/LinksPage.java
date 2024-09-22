package demoqa.forms.pages;

import demoqa.elements.ButtonElement;
import demoqa.forms.BaseForm;
import org.openqa.selenium.By;

public class LinksPage extends BaseForm {
    private ButtonElement homeButton = new ButtonElement(By.xpath("//a[@id='simpleLink']"), "homeButton");

    public LinksPage() {
        super(By.xpath("//a[@id='simpleLink']"), "linksPage");
    }

    public void clickHomeLink() {
        homeButton.click();
    }
}