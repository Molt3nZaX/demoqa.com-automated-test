package demoqa.forms.pages;

import demoqa.forms.BaseForm;
import org.openqa.selenium.By;

public class FramesPage extends BaseForm {

    public FramesPage() {
        super(By.xpath("//div[@id='framesWrapper']"), "framesPage");
    }
}