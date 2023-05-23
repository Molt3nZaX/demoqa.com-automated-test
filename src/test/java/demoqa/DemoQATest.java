package demoqa;

import demoqa.browser.ActionsWithBrowser;
import demoqa.forms.*;
import demoqa.forms.pages.*;
import demoqa.models.Person;
import demoqa.utils.AlertsUtils;
import demoqa.utils.DataConstantsUtils;
import demoqa.utils.TestDataUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class DemoQATest extends DemoQABaseTest implements DataConstantsUtils {

    @Test(testName = "alerts")
    public void alertTest() {
        logStepInfo("Navigate to main page");
        DemoQaMainPage demoQaMainPage = new DemoQaMainPage();
        assertTrue(demoQaMainPage.isPageOpened(), "Main page is not opened");

        logStepInfo("Click on \"Alerts, Frame & Windows\" button. In a menu click Alerts button.");
        demoQaMainPage.moveToAlertsFrameWindowsButtonAndClick();
        AccordionMenu accordionMenu = new AccordionMenu();
        accordionMenu.clickOnAlertsButton();

        logStepInfo("Click on \"Click Button to see alert\" button");
        AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage();
        assertTrue(alertsWindowsPage.isPageOpened(), "Alert form not appearing on the page");

        alertsWindowsPage.clickButtonToSeeAlert();
        assertEquals(AlertsUtils.getText(), TestDataUtils.getTestData().getExpectedTextInAlert(),
                "Alert with the text \"You clicked the button\" doesn't open");

        logStepInfo("Click \"OK\" button");
        AlertsUtils.alertAccept();
        assertTrue(alertsWindowsPage.buttonToSeeAlertIsDisplayed(), "Alert isn't closed");

        logStepInfo("Click on \"On button click, confirm box will appear\" button");
        alertsWindowsPage.clickButtonConfirmBox();
        assertEquals(AlertsUtils.getText(), TestDataUtils.getTestData().getExpectedTextInConfirmAlert(),
                "Alert with text \"Do you confirm action?\" doesn't open");

        logStepInfo("Click \"OK\" button");
        AlertsUtils.alertAccept();
        assertTrue(alertsWindowsPage.buttonToSeeAlertIsDisplayed(), "Alert isn't closed");
        assertEquals(alertsWindowsPage.getConfirmResultText(), TestDataUtils.getTestData().getTextAfterClosingConfirmAlert(),
                "Text \"You selected Ok\" doesn't appear on page");

        logStepInfo("Click on \"On button click, prompt box will appear\" button");
        alertsWindowsPage.clickButtonPromptBox();
        assertEquals(AlertsUtils.getText(), TestDataUtils.getTestData().getExpectedTextInPromptAlert(),
                "Alert with text \"Please enter your name\" doesn't open");

        logStepInfo("Enter randomly generated text, click \"OK\" button");
        AlertsUtils.sendRandomTextToAlert();
        AlertsUtils.alertAccept();
        assertTrue(alertsWindowsPage.buttonToSeeAlertIsDisplayed(), "Alert isn't closed");
        assertTrue((alertsWindowsPage.getPromptResultText()).contains(TestDataUtils.getRandomName()),
                "Appeared text is not the one you enter before");
    }

    @Test(testName = "iframe")
    public void iframeTest() {
        logStepInfo("Navigate to main page");
        DemoQaMainPage demoQaMainPage = new DemoQaMainPage();
        assertTrue(demoQaMainPage.isPageOpened(), "Main page is not opened");

        logStepInfo("Click on \"Alerts, Frame & Windows\" button. In a menu click \"Nested Frames\" button");
        demoQaMainPage.moveToAlertsFrameWindowsButtonAndClick();
        AccordionMenu accordionMenu = new AccordionMenu();
        accordionMenu.clickOnNestedFramesButton();
        NestedFramesPage nestedFramesPage = new NestedFramesPage();
        assertTrue(nestedFramesPage.isPageOpened(), "Page with Nested Frames form is not opened");
        ParentFrame parentFrame = new ParentFrame();
        assertEquals(parentFrame.getTextFromParentFrame(), TestDataUtils.getTestData().getExpectedParentMessage(),
                "The messages \"Parent frame\" is not displayed on page");
        ChildFrame childFrame = new ChildFrame();
        assertEquals(childFrame.getTextFromChildFrame(), TestDataUtils.getTestData().getExpectedChildMessage(),
                "The messages \"Child Iframe\" is not displayed on page");

        logStepInfo("Select \"Frames\" option in a left menu");
        accordionMenu.clickOnFramesButton();
        FramesPage framesPage = new FramesPage();
        assertTrue(framesPage.isPageOpened(), "Frames Page is not opened");
        UpperFrame upperFrame = new UpperFrame();
        BottomFrame bottomFrame = new BottomFrame();
        assertEquals(upperFrame.getBodyText(), bottomFrame.getBodyText(),
                "Message from upper frame is not equal to the message from lower frame");
    }

    @DataProvider(name = "Person Data provider")
    public Object[][] PersonDataProvider() {
        return new Object[][]{{PATH_TO_FIRST_TABLE_TEST_DATA}, {PATH_TO_SECOND_TABLE_TEST_DATA}};
    }

    @Test(testName = "tables", dataProvider = "Person Data provider")
    public void tablesTest(String pathToTestDataJson) {
        logStepInfo("Navigate to main page");
        DemoQaMainPage demoQaMainPage = new DemoQaMainPage();
        assertTrue(demoQaMainPage.isPageOpened(), "Main page is not opened");

        logStepInfo("Click on \"Elements\" button In the menu click a \"Web Tables\" button");
        demoQaMainPage.moveToElementsButtonAndClick();
        AccordionMenu accordionMenu = new AccordionMenu();
        accordionMenu.clickOnWebTables();
        WebTablesPage webTablesPage = new WebTablesPage();
        assertTrue(webTablesPage.isPageOpened(), "Web Tables page is not opened");

        logStepInfo("Click on \"Add\" button");
        List<Person> personListFromData = webTablesPage.getPersonListFromJson(pathToTestDataJson);
        webTablesPage.clickAddButton();
        RegistrationForm registrationForm = new RegistrationForm();
        assertTrue(registrationForm.isPageOpened(), "Registration Form is not displayed");

        logStepInfo("Enter data for \"User №\" from the table and then click \"Submit\" button");
        registrationForm.fillFormByPeopleAndSubmit(personListFromData.get(0));
        assertTrue(webTablesPage.isPageOpened(), "Registration form is not closed");
        assertTrue(webTablesPage.getActualPersonListFromTable().contains(personListFromData.get(0)),
                "Data of User wasn't appeared in a table");

        logStepInfo("Click \"Delete\" button in a row which contains data of User №");
        int sizePersonsListBeforeDeleteRow = webTablesPage.getActualPersonListFromTable().size();
        webTablesPage.deleteLastRow();
        int sizePersonsListAfterDeleteRow = webTablesPage.getActualPersonListFromTable().size();
        assertNotEquals(sizePersonsListBeforeDeleteRow, sizePersonsListAfterDeleteRow,
                "Number of records in table is not changed");
        assertFalse(webTablesPage.getActualPersonListFromTable().contains(personListFromData.get(0)),
                "Data of User wasn't deleted from table");
    }

    @Test(testName = "handles")
    public void handlesTest() {
        logStepInfo("Navigate to main page");
        DemoQaMainPage demoQaMainPage = new DemoQaMainPage();
        assertTrue(demoQaMainPage.isPageOpened(), "Main page is not opened");

        logStepInfo("Click on \"Alerts, Frame & Windows\" button In the menu click a \"Browser Windows\" button");
        demoQaMainPage.moveToAlertsFrameWindowsButtonAndClick();
        AccordionMenu accordionMenu = new AccordionMenu();
        accordionMenu.clickOnBrowserWindowsButton();
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
        assertTrue(browserWindowsPage.isPageOpened(), "Page with Browser Windows form is not opened");

        logStepInfo("Click on \"New Tab\" button");
        browserWindowsPage.clickNewTabButton();
        ActionsWithBrowser actionsWithBrowser = new ActionsWithBrowser();
        actionsWithBrowser.switchToTab(1);
        NewTabPage newTabPage = new NewTabPage();
        assertTrue(newTabPage.isPageOpened(), "Page with Browser Windows form is not opened");

        logStepInfo("Close current tab");
        actionsWithBrowser.closeCurrentTab();
        actionsWithBrowser.switchToTab(0);
        logStepInfo("In the menu on the left click \"Elements\" → \"Links\" button");
        accordionMenu.clickOnElementsButton();
        accordionMenu.ClickOnLinksButton();
        LinksPage linksPage = new LinksPage();
        assertTrue(linksPage.isPageOpened(), "Page with Link form is not opened");

        logStepInfo("Click on \"Home\" link");
        linksPage.clickHomeLink();
        actionsWithBrowser.switchToTab(1);
        assertTrue(demoQaMainPage.isPageOpened(), "Main page is not opened");

        logStepInfo("Resume to previous tab");
        actionsWithBrowser.closeCurrentTab();
        actionsWithBrowser.switchToTab(0);
        assertTrue(linksPage.isPageOpened(), "Page with Link form is not opened");
    }
}