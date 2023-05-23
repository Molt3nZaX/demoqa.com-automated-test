package demoqa.models;

import lombok.Data;

@Data
public class TestData {
	private String textAfterClosingConfirmAlert;
	private String expectedTextInConfirmAlert;
	private String expectedChildMessage;
	private String expectedParentMessage;
	private String expectedTextInPromptAlert;
	private String expectedTextInAlert;
}