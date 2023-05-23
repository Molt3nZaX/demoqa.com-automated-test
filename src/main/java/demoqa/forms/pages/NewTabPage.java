package demoqa.forms.pages;

import demoqa.forms.BaseForm;
import org.openqa.selenium.By;

public class NewTabPage extends BaseForm {

    public NewTabPage() {
        super(By.xpath("//h1[@id='sampleHeading']"),"newTabPage");
    }
}