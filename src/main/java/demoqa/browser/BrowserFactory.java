package demoqa.browser;

import demoqa.utils.ConfigDataUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
    private static WebDriver webDriver = null;
    private static final ChromeOptions chromeOptions = new ChromeOptions();
    private static final FirefoxOptions firefoxOptions = new FirefoxOptions();

    public static WebDriver getBrowser(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox" -> {
                if (webDriver == null) {
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver(getFirefoxOptions());
                }
            }
            case "chrome" -> {
                if (webDriver == null) {
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver(getChromeOptions());
                }
            }
            default -> throw new IllegalArgumentException("Invalid browser type");
        }
        return webDriver;
    }

    public static void killDriver() {
        webDriver = null;
    }

    private static ChromeOptions getChromeOptions() {
        return chromeOptions.addArguments(ConfigDataUtils.getBrowserConfig().getChromeOptionsList());
    }

    private static FirefoxOptions getFirefoxOptions() {
        return firefoxOptions.addArguments(ConfigDataUtils.getBrowserConfig().getFirefoxOptions());
    }
}