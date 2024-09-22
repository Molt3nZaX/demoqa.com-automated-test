package demoqa.forms.pages;

import demoqa.forms.BaseForm;
import org.openqa.selenium.By;

public class NestedFramesPage extends BaseForm {

    public NestedFramesPage() {
        super( By.xpath("//div[contains(text(),'Nested')]"), "nestedFramesPage");
    }
}