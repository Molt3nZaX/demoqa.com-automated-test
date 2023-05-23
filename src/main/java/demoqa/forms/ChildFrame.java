package demoqa.forms;

import demoqa.elements.LabelElement;
import demoqa.utils.FramesUtils;
import org.openqa.selenium.By;

public class ChildFrame extends BaseForm {
    private final LabelElement childBodyText = new LabelElement(By.tagName("p"), "childFrameLabel");

    public ChildFrame() {
        super(null, "Frame: childFrame");
    }

    public String getTextFromChildFrame() {
        FramesUtils.switchToFrame("frame1");
        FramesUtils.switchToChild();
        String textFromChildFrame = childBodyText.getText();
        FramesUtils.defaultContent();
        return textFromChildFrame;
    }
}