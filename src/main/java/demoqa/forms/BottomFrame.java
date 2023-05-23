package demoqa.forms;

import demoqa.elements.LabelElement;
import demoqa.utils.FramesUtils;
import org.openqa.selenium.By;

public class BottomFrame extends BaseForm {
    private LabelElement bodyText = new LabelElement(By.xpath("//h1[@id='sampleHeading']"), "frame2BodyText (lower)");

    public BottomFrame() {
        super(By.xpath("//div[contains(@id,'frame2')]"), "Frame: frame2");
    }

    public String getBodyText() {
        FramesUtils.switchToFrame("frame2");
        String textFromFrame = bodyText.getText();
        FramesUtils.defaultContent();
        return textFromFrame;
    }
}