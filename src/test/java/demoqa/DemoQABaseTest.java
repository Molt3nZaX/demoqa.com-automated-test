package demoqa;

import demoqa.browser.SingletonWebDriver;
import demoqa.utils.ConfigDataUtils;
import demoqa.utils.LoggerUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class DemoQABaseTest extends LoggerUtils {

    @BeforeMethod
    public void setUp() {
        WebDriver webDriver = SingletonWebDriver.getWebDriver();
        webDriver.navigate().to(ConfigDataUtils.getBrowserConfig().getBaseUrl());
    }

    @AfterMethod
    public void tearDown() {
        SingletonWebDriver.teardown();
    }
}