package demoqa.forms;

import demoqa.elements.LabelElement;
import demoqa.utils.FramesUtils;
import org.openqa.selenium.By;

public class UpperFrame extends BaseForm {
    private LabelElement bodyText = new LabelElement(By.xpath("//h1[@id='sampleHeading']"), "frame1BodyText (upper)");

    public UpperFrame() {
        super(By.xpath("//div[contains(@id,'frame1')]"), "Frame: frame1");
    }

    public String getBodyText() {
        FramesUtils.switchToFrame("frame1");
        String textFromFrame = bodyText.getText();
        FramesUtils.defaultContent();
        return textFromFrame;
    }
}