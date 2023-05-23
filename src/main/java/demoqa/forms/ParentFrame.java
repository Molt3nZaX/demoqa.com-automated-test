package demoqa.forms;

import demoqa.elements.LabelElement;
import demoqa.utils.FramesUtils;
import org.openqa.selenium.By;

public class ParentFrame extends BaseForm {
    private LabelElement parentBodyText = new LabelElement(By.tagName("body"), "parentBodyText");

    public ParentFrame() {
        super(By.xpath("//iframe[@id='frame1']"),"Frame: parentFrame");
    }

    public String getTextFromParentFrame() {
        FramesUtils.switchToFrame("frame1");
        String textFromParentFrame = parentBodyText.getText();
        FramesUtils.defaultContent();
        return textFromParentFrame;
    }
}